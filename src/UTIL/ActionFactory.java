package UTIL;


import MEMBER.*;
import QnABBS.QnaListAction;
import QnABBS.QnaViewAction;
import QnABBS.QnaWriteAction;
import QnABBS.QnaWriteFormAction;
import TriporTrap.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	public ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory :" + command);
		if (command.equals("traplist")) {
			action = new TrapListOther();
		} else if (command.equals("mytraps")) {
			action = new MyTraps();
			
		} else if (command.equals("trapadd")) {
			action = new AddTrap();
		
			
			
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("find_zip_num")) {
			 action = new FindZipNumAction();
		} else if (command.equals("join")) {
			 action = new JoinAction();
		} else if (command.equals("login_form")) {
			 action = new LoginFormActoin();
		} else if (command.equals("login")) {
			 action = new LoginActoin();
		} else if (command.equals("logout")) {
			 action = new LogoutActoin();
		} else if(command.equals("qna_list")){
			 action = new QnaListAction();
		} else if (command.equals("qna_write_form")) {
			 action = new QnaWriteFormAction();
		} else if (command.equals("qna_write")) {
			 action = new QnaWriteAction();
		} else if (command.equals("qna_view")) {
			 action = new QnaViewAction();
		}
		return action;
	}
}