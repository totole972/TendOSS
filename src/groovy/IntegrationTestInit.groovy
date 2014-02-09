/**
 * Created by totole on 09/02/14.
 */
package tendoss.test
import tendoss.User

class IntegrationTestInit {

    static initData(){

        //create users
        for(int i = 0; i<15; i++){
            new User(username: "user${i}", password: "user${i}", emailAddress: "user${i}"+"@yopmail.com")
        }


        //create tenders



        //create answers


        //create votes

            //for users
            //for tenders
            //for answers

    }

}
