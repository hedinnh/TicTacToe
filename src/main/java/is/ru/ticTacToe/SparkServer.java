package is.ru.ticTacToe;

import org.json.simple.JSONObject;
//import spark.*;
import static spark.Spark.*;
//import spark.servlet.SparkApplication;

public class SparkServer {
	TicTacToe ttt;
	
	
	public SparkServer() {
		ttt = new TicTacToe();
		staticFileLocation("/public");
		
		get("/reset", (req, res) -> {
			ttt = new TicTacToe();
			return ttt.updateCell();
		});
		get("/updateCell/:cell", (req, res) -> {
			return ttt.updateCell(Integer.parseInt(req.params(":cell")));
		});
		
	}
	
	
	
	public static String test() {
		return "a";
	}
	public static void main(String[] args) {
	//get("/", (req, res) -> test());	
		//Spark
	new SparkServer();
	}

}
