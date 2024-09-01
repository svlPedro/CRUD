package Models;

public class Processo {

	private int id;
	private String contractor;
	private int pages;
	private int companys;
	private String lecturer;
	private int points;
	
	public Processo() {
		
	}
	
	public Processo(String contractor, int pages, int companys, String lecturer) {
		this.contractor = contractor;
		this.pages = pages;
		this.companys = companys;
		this.lecturer = lecturer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getCompanys() {
		return companys;
	}

	public void setCompanys(int companys) {
		this.companys = companys;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}	
}
