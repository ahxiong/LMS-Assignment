package data;

/**
 * Created by Mister_Brown on 4/17/2017.
 */
public class Member {
    int MemberID;
	String Name;
    String CardID;
    String Gender;
    String RegisterDate;
    String ExpireDate;
    String Mobile;
    String Email;
    String Address;

    public Member(){
    	super();
    }
    
    public void setMemberID(int id){
    	MemberID = id;
    }
    public int getMemberID(){
    	return MemberID;
    }
    
    public Member(int id,String name, String cardID, String gender, String registerDate, String expireDate, String mobile, String email, String address) {
        MemberID =id;
    	Name = name;
        CardID = cardID;
        Gender = gender;
        RegisterDate = registerDate;
        ExpireDate = expireDate;
        Mobile = mobile;
        Email = email;
        Address = address;
    }

    public String[] GetData(){
        return new String[]{
                Name,
                CardID,
                Gender,
                RegisterDate,
                ExpireDate,
                Mobile,
                Email,
                Address
        };
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(String registerDate) {
        RegisterDate = registerDate;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

}
