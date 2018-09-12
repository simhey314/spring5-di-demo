package guru.springframework.examplebeans;

public class FakeJmsBroker {

	private String user;
	private String password;
	private String url;

	public FakeJmsBroker() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FakeJmsBroker{" +
				"user='" + user + '\'' +
				", password='" + password + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
