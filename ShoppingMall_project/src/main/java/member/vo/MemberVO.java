package member.vo;

public class MemberVO {

	private int m_num;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_tel;
	private String m_address;
	private int m_level;
	
	public MemberVO() {
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public int getM_level() {
		return m_level;
	}

	public void setM_level(int m_level) {
		this.m_level = m_level;
	}

	@Override
	public String toString() {
		return "MemberVO [m_num=" + m_num + ", m_id=" + m_id + ", m_password=" + m_password + ", m_name=" + m_name
				+ ", m_tel=" + m_tel + ", m_address=" + m_address + ", m_level=" + m_level + ", getM_num()="
				+ getM_num() + ", getM_id()=" + getM_id() + ", getM_password()=" + getM_password() + ", getM_name()="
				+ getM_name() + ", getM_tel()=" + getM_tel() + ", getM_address()=" + getM_address()
				+ ", getM_level()=" + getM_level() + "]";
	}
	
	
}
