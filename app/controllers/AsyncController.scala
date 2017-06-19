package controllers

import java.util

import com.microsoft.z3.Context
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

/**
  * This controller creates an `Action` that demonstrates how to write
  * simple asynchronous code in a controller.
  */
object AsyncController extends Controller {

  import play.api.libs.concurrent.Execution.Implicits.defaultContext

  def testZ3 = Action.async {
    simpleZ3Check().map(res => Ok(res))
  }

  private def simpleZ3Check(): Future[String] = Future {
    val config = new util.HashMap[String, String]()
    config.put("model", "true")
    config.put("unsat_core", "true")  
    val context = new Context(config)
    val a = 4
    val b = 8
    val ia = context.mkIntConst("a")
    val ib = context.mkIntConst("b")
    val ic = context.mkIntConst("c")
    val solver = context.mkSolver()
    solver.add(context.mkEq(context.mkAdd(ia, ib), ic))
    solver.add(context.mkEq(ia, context.mkInt(a)))
    solver.add(context.mkEq(ib, context.mkInt(b)))
    if (solver.check() == com.microsoft.z3.Status.SATISFIABLE)
      solver.getModel.toString
    else
      s"Failed find value for c in equation $a + $b = c"
  }
}
