package com.example.mycovid19.Service.Backup;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Model.Test;
import com.example.mycovid19.Service.Admin.SeeAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BackupService {

    public static String formattedTodaysDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-(kk-mm-ss)");
        Date today = Calendar.getInstance().getTime();
        String formattedTodaysDate = format.format(today);
        return formattedTodaysDate;
    }


    public static void printMemberList(){

        SeeAllUsersService seeAllUsersService = null;
        ArrayList<MyProfile> allUsersList = seeAllUsersService.ResultSet();
        String printingDate = BackupService.formattedTodaysDate();

        try {
            String memberListFileName = "src/main/java/com/example/mycovid19/Service/Backup/users_list_"+printingDate+".csv";
            FileWriter userListWriter = new FileWriter(memberListFileName); //Constructs a FileWriter object given a file name with a boolean indicating whether or not to append the data written.

            for(MyProfile user : allUsersList)
            {
                userListWriter.write(user.toString() + System.lineSeparator());
            }
            userListWriter.close();

        }

        catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace(); // prints where the error occured to the console. e only prints the vague error
        }

    }


}
