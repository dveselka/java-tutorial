package ldap;

import java.util.ArrayList;
import java.util.Properties;

import javax.management.Attribute;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class TestLDAP {
	private static final String CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";

	private InitialDirContext ctx;
	private String basedn;
	private SearchControls ctrls;

	private TestLDAP(String url, String user, String password, String b) throws NamingException {
		ctx = TestLDAP.doConnect(url, user, password);
		basedn = b.length() > 0 ? "," + b : b;
		ctrls = new SearchControls();
	}

	public ArrayList<Attributes> search(String base, String filter) throws NamingException {
		NamingEnumeration<SearchResult> ne = ctx.search(base + basedn, filter, ctrls);
		ArrayList<Attributes> arr = new ArrayList<>();
		while (ne.hasMore()) {
			arr.add(ne.next().getAttributes());
		}
		return arr;
	}

	public Attributes get(String base) throws NamingException {
		return ctx.getAttributes(base + basedn);
	}

	private static InitialDirContext doConnect(String url, String user, String password) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY);
		props.put(Context.PROVIDER_URL, url);
		props.put(Context.SECURITY_PRINCIPAL, user);
		props.put(Context.SECURITY_CREDENTIALS, password);

		return new InitialDirContext(props);
	}

	public static TestLDAP connect(String url, String user, String pass, String basedn) throws NamingException {
		return new TestLDAP(url, user, pass, basedn);
	}

	public static boolean testConnection(String url, String user, String password) {
		try {
			return TestLDAP.doConnect(url, user, password) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			TestLDAP testLDAP = new TestLDAP("ldap://ldap.forumsys.com", "cn=read-only-admin,dc=example,dc=com",
					"password", "dc=example,dc=com");
			Attributes attributes = testLDAP.get("uid=Newton");

			NamingEnumeration<? extends javax.naming.directory.Attribute> allAttributes = attributes
					.getAll();
			while (allAttributes.hasMore()) {
				javax.naming.directory.Attribute attribute = allAttributes.next();
				System.out.println(attribute.getID() + "=" + attribute.get().toString());
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}