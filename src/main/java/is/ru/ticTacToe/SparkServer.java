package is.ru.ticTacToe;

import org.json.simple.JSONObject;
import static spark.Spark.*;


public class SparkServer {
	TicTacToe ttt;
	
	public SparkServer() {
		ttt = new TicTacToe();
		staticFileLocation("/public");
		
		post("/reset", (req, res) -> {
			res.type("application/json");
			return ttt.reset();
		});
		post("/updateCell", (req, res) -> {
			res.type("application/json");
			return ttt.updateCell(Integer.parseInt(req.queryParams("id")));
		});	
	}

	public static void main(String[] args) {
	String port = System.getenv("PORT");
        if (port != null) {
        port(Integer.valueOf(port));
    }
	new SparkServer();
	}

}
