package net.admin.goods.action;

public class ActionForward {
	// 이동 방식 저장 : false일 경우 : forward() , .jsp로 이동 시
	// true일 경우 : sendRedirect()
	private boolean isRedirect = false; 
	// 이동 경로 저장
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
