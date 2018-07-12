import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    private File file=null;
    private List<Message> list=new ArrayList<>();
    private UserManager() throws IOException {
        String line=null;
        FileReader fileReader=new FileReader("data.txt");
        BufferedReader in=new BufferedReader(fileReader);
        while ((line=in.readLine())!=null)
        {
            String a[]=line.split("[+]{4,}|#");
            Message ob=new Message();
            ob.setTs(Integer.parseInt(a[0]));
            ob.setDataSender(a[1]);
            ob.setDataType(Integer.parseInt(a[2]));
            ob.setData(a[3]);
            list.add(ob);
        }
    }
    private static UserManager userManager=null;
    public static UserManager getInstance() throws IOException {
        if (userManager==null)
            userManager=new UserManager();
        return userManager;
    }
    public List<Message> getSortedMessage(int order)  // '1' for increasing order and '2' for decreasing order
    {
        Collections.sort(list, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                if (order==1)
                return o1.getTs()-o2.getTs();
                return o2.getTs()-o1.getTs();
            }
        });
        return list;
    }
    public List<Message> getMessagesFromSender(String sender)
    {
        ArrayList<Message> messages=new ArrayList<>();
        for (Message message:list)
        {
            if (message.getDataSender().compareTo(sender)==0)
                messages.add(message);
        }
        return messages;
    }
    public List<Message> getMessagesOfType(int type)
    {
        ArrayList<Message> messages=new ArrayList<>();
        for (Message message:list)
        {
            if (message.getDataType()==type)
                messages.add(message);
        }
        return messages;
    }
    public UserDetails getUserDetails(int uid)
    {
        UserDetails ob=new UserDetails();
        for (Message message:list)
        {
         if (message.getDataType()==1)
         {
             UserProfileData profileData=DataParser.kvProfile(message.data);
             if (profileData.getUid()==uid) {
                 ob.setName(profileData.getName());
                 ob.setAdd(profileData.getAdd());
                 ob.setUid(profileData.uid);
             }
         }
         else if (message.getDataType()==2)
         {
             UserMedicalDetails medicalDetails=new UserMedicalDetails();
             if (medicalDetails.getUid()==uid)
             {
                 ob.setBg(medicalDetails.getBg());
                 ob.setHeight(medicalDetails.getHeight());
                 ob.setWeight(medicalDetails.getWeight());
             }
         }
         else if (message.getDataType()==3)
         {
             UserBillingDetails billingDetails=new UserBillingDetails();
             if (billingDetails.getUid()==uid)
             {
                 ob.setMethod(billingDetails.getMethod());
                 ob.setTid(billingDetails.getTid());
                 ob.setCount(billingDetails.getCount());
                 ob.setAmount(billingDetails.getAmount());
             }
         }
        }
        return ob;
    }


}
