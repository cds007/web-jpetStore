package org.csu.webJpetStore.persistence.Impl;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {
    public static final String INSERT_USER=
            "INSERT INTO account(userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_ACCOUNT=
            "INSERT INTO signon(username,password) VALUES (?,?)";
    public static final String INSERT_PROFILE=
            "INSERT INTO profile(userid,langpref,favcategory,mylistopt,banneropt) VALUES (?,?,?,?,?)";
    public static final String REMOVE_ACCOUNT=
            "DELETE FROM signon,account,profile,bannerdata WHERE account.userid=? AND signon.password=?";
    public static final String UPDATA1_ACCOUNT=
            "UPDATE signon SET "+
                    "signon.password=?" +
                    "WHERE signon.username=? AND signon.password=? ";

    public static final String UPDATA2_ACCOUNT=
            "UPDATE account SET "+
                    "account.email=?,account.firstname=?,account.lastname=?,account.status=?," +
                    "account.addr1=?,account.addr2=?,account.city=?,account.state=?,account.zip=?,account.country=?,account.phone=? " +
                    "WHERE account.userid=? ";

    public static final String UPDATA_ACCOUNT=
            "UPDATE"+
                    " profile SET "+
                    "profile.langpref=?,profile.favcategory=?,profile.mylistopt=?,profile.banneropt=?,profile.userid=? " +
                    "WHERE profile.userid=?  ";

    /* 这个地方完成插入的任务*/
    public static final String SEARCH_ACCOUNT_BY_USERNAME_PASSWORD=
            "SELECT  " +
                    "profile.langpref,profile.favcategory,profile.mylistopt,profile.banneropt,profile.userid," +
                    "signon.username," +
                    "account.email,account.firstname,account.lastname,account.status," +
                    "account.addr1,account.addr2,account.city,account.state,account.zip,account.country,account.phone," +
                    "bannerdata.bannername " +
                    "FROM signon,account,profile,bannerdata "+
                    "WHERE account.userid=? AND signon.password=? "+
                    "AND signon.username = account.userid "+
                    "AND profile.userid = signon.username "+
                    "AND profile.favcategory = bannerdata.favcategory";
    /* account是新的对象，account2是原来的对象 */

    public Account UpdateAccount1(Account account, Account account2){
        Account account1=null;
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATA1_ACCOUNT);
            PreparedStatement preparedStatement1=connection.prepareStatement(UPDATA2_ACCOUNT);
            PreparedStatement preparedStatement2=connection.prepareStatement(UPDATA_ACCOUNT);
            preparedStatement2.setString(1, account.getLangpref());
            preparedStatement2.setString(5, account.getUserid());
            preparedStatement2.setString(2,account.getFavcategory());
            preparedStatement2.setInt(3,account.isMylistopt() ? 1:0);
            preparedStatement2.setInt(4,account.isBanneropt() ? 1:0);
            preparedStatement2.setString(6,account2.getName());
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.setString(3,account2.getPassword());
            preparedStatement.setString(2,account2.getUserid());
            preparedStatement1.setString(12,account2.getUserid());
            preparedStatement1.setString(1,account.getEmail());
            preparedStatement1.setString(2, account.getFirstname());
            preparedStatement1.setString(3, account.getLastname());
            preparedStatement1.setString(4, account.getStatus());
            preparedStatement1.setString(5, account.getAddr1());
            preparedStatement1.setString(6, account.getAddr2());
            preparedStatement1.setString(7, account.getCity());
            preparedStatement1.setString(8, account.getState());
            preparedStatement1.setString(9,account.getZip());
            preparedStatement1.setString(10,account.getCountry());
            preparedStatement1.setString(11,account.getPhone());
            int rows=preparedStatement.executeUpdate();
            int rows1=preparedStatement1.executeUpdate();
            int rows2=preparedStatement2.executeUpdate();
            if (rows==1 && rows1==1 && rows2==1){
                account1=account;
            }
            DBUtil.closePreparedStatent(preparedStatement);
            DBUtil.closePreparedStatent(preparedStatement1);
            DBUtil.closePreparedStatent(preparedStatement2);
            DBUtil.closeConnection(connection);
            return account1;
            /*此处要删除一个account对象*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public Account SearchAccountByUsernameAndPassword(String username,String password){
        Account account=null;
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_ACCOUNT_BY_USERNAME_PASSWORD);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                account=new Account();
                account.setName(username);
                account.setPassword(password);
                account.setAddr1(resultSet.getString("account.addr1"));
                account.setAddr2(resultSet.getString("account.addr2"));
                account.setCity(resultSet.getString("account.city"));
                account.setCountry(resultSet.getString("account.country"));
                account.setEmail(resultSet.getString("account.email"));
                account.setBannername(resultSet.getString("bannerdata.bannername"));
                account.setBanneropt(resultSet.getBoolean("profile.banneropt"));
                account.setFavcategory(resultSet.getString("profile.favcategory"));
                account.setFirstname(resultSet.getString("account.firstname"));
                account.setLastname(resultSet.getString("account.lastname"));
                account.setState(resultSet.getString("account.state"));
                account.setStatus(resultSet.getString("account.status"));
                account.setZip(resultSet.getString("account.zip"));
                account.setPhone(resultSet.getString("account.phone"));
                account.setLangpref(resultSet.getString("profile.langpref"));
                account.setMylistopt(resultSet.getBoolean("profile.mylistopt"));
                account.setUserid(resultSet.getString("profile.userid"));
                System.out.println("succeess");
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatent(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public boolean insertAccount(Account account){
        boolean result=false;
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER);
            PreparedStatement preparedStatement1=connection.prepareStatement(INSERT_ACCOUNT);
            PreparedStatement preparedStatement2=connection.prepareStatement(INSERT_PROFILE);
            preparedStatement2.setString(1, account.getUserid());
            preparedStatement2.setString(2, account.getLangpref());
            preparedStatement2.setString(3,account.getFavcategory());
            preparedStatement2.setInt(4,account.isMylistopt() ? 1:0);
            preparedStatement2.setInt(5,account.isBanneropt() ? 1:0);
            preparedStatement1.setString(1,account.getName());
            preparedStatement1.setString(2,account.getPassword());
            preparedStatement.setString(1,account.getUserid());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3, account.getFirstname());
            preparedStatement.setString(4, account.getLastname());
            preparedStatement.setString(5, account.getStatus());
            preparedStatement.setString(6, account.getAddr1());
            preparedStatement.setString(7, account.getAddr2());
            preparedStatement.setString(8, account.getCity());
            preparedStatement.setString(9, account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11,account.getCountry());
            preparedStatement.setString(12,account.getPhone());
            int rows=preparedStatement.executeUpdate();
            int rows1=preparedStatement1.executeUpdate();
            int rows2=preparedStatement2.executeUpdate();
            if (rows==1 && rows1==1 && rows2==1){
                result=true;
            }
            DBUtil.closePreparedStatent(preparedStatement);
            DBUtil.closePreparedStatent(preparedStatement1);
            DBUtil.closePreparedStatent(preparedStatement2);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
