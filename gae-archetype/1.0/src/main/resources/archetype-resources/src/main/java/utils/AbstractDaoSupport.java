/**
 * 
 */
package ${package}.utils;

/**
 * @author Bill
 *
 */
public abstract class AbstractDaoSupport {
	
	private JdoTemplate jdoTemplate;

	/**
	 * 
	 */
	public AbstractDaoSupport() {
		// TODO Auto-generated constructor stub
		jdoTemplate = new JdoTemplate();
	}

	/**
	 * @param jdoTemplate the jdoTemplate to set
	 */
	public void setJdoTemplate(JdoTemplate jdoTemplate) {
		this.jdoTemplate = jdoTemplate;
	}

	/**
	 * @return the jdoTemplate
	 */
	public JdoTemplate getJdoTemplate() {
		return jdoTemplate;
	}

}
