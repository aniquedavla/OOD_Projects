
/**
  MailSystemTester tests accessing mail system with two telephones
 * Created by aniquedavla on 4/8/17.
*/
public class MailSystemTester
{
   private static int MAILBOX_NUM = 20;

   /**
     Creates two phones and connects them to the system.
   */
   public static void main(String[] args)
   {
      MailSystem system = new MailSystem(MAILBOX_NUM);

      Telephone p1 = new Telephone();
      Telephone p2 = new Telephone();
      Connection c1 = new Connection(system, p1);
      Connection c2 = new Connection(system, p2);
      p1.run(c1);
      p2.run(c2);
   }

}