package rpc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBConnection connection = DBConnectionFactory.getConnection();

		try {
			JSONObject obj = RpcHelper.readJSONObject(request);
			String userId = obj.getString("user_id");
			String password = obj.getString("password");
			String firstname = obj.getString("first_name");
			String lastname = obj.getString("last_name");

			JSONObject obj2 = new JSONObject();
			if (connection.registerUser(userId, password, firstname, lastname)) {
				obj2.put("status", "OK");
			} else {
				obj2.put("status", "User Already Exists");
			}
			RpcHelper.writeJsonObject(response, obj);

		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
