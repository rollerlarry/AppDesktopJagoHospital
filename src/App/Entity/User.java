package App.Entity;

public abstract class User {
    private String userName;
    private String passWord;
    private String birthDay;
    private String fullName;
    private boolean gender;

    public User() {
        this.userName = "";
        this.passWord = "";
        this.birthDay = "";
        this.fullName = "";
        this.gender = false;
    }

    public User(String userName, String passWord, String birthDay, String fullName, boolean gender) {
        this.userName = userName;
        this.passWord = passWord;
        this.birthDay = birthDay;
        this.fullName = fullName;
        this.gender = gender;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

//    public void SignUp(String userName, String passWord, String birthDay, String fullName){
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.getConnection();
//
//        String sqlInsert = "INSERT INTO tb_users(user_name,pass_word,birth_day,full_name) VALUES('"+userName+"','"+passWord+"','"+birthDay+"','"+fullName+"')";
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(sqlInsert);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
