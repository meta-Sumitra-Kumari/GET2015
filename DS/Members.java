
/**
 * @author Sumitra
 * this is POJO class for members.
 */
public class Members {
int member_id;
String member_nm;
String addressLine1;
String addressLine2;
String categorgy;
String person_type;
public int getMember_id() {
	return member_id;
}
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
public String getMember_nm() {
	return member_nm;
}
public void setMember_nm(String member_nm) {
	this.member_nm = member_nm;
}
public String getAddressLine1() {
	return addressLine1;
}
public Members(int member_id, String member_nm, String addressLine1,
		String addressLine2, String string, String string2) {
	super();
	this.member_id = member_id;
	this.member_nm = member_nm;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.categorgy = string;
	this.person_type = string2;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}
public String getCategorgy() {
	return categorgy;
}
public void setCategorgy(String categorgy) {
	this.categorgy = categorgy;
}
public String getPerson_type() {
	return person_type;
}
public void setPerson_type(String person_type) {
	this.person_type = person_type;
}
}
