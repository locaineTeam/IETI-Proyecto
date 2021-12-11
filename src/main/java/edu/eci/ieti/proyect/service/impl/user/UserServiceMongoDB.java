package edu.eci.ieti.proyect.service.impl.user;

import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.FacadeRepository;
import edu.eci.ieti.proyect.repository.UserRepository;
import edu.eci.ieti.proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.*;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;
    private final FacadeRepository facadeRepository;
    private String[] nombres = {"mamberroy", "Adam Baum", "Adam Zapel", "Al Bino", "Al Dente", "Al Fresco", "Al K. Seltzer", "Alf A. Romeo", "Ali Gaither", "Amanda Lay ", "Amanda Lynn ", "Amber Green", "Andy Friese ", "Angelina Cage", "Anita Bathe", "Anita Job", "Anna Conda", "Anna Fender ", "Anna Graham", "Anna Prentice ", "Anna Recksiek ", "Anna Sasin", "Anne Teak", "Annette Curtain", "Annie Howe", "April May ", "April Schauer ", "Aretha Holly", "Armand Hammer", "Art Major", "Athol", "B.A. Ware", "Barb Dwyer", "Barb E. Dahl", "Barbara Seville", "Barry Cade", "Bea Minor and Dee Major", "Beau Archer", "Ben Dover", "Ben Marcata ", "Bess Eaton ", "Biff Wellington", "Bill Board", "Bill Ding", "Bill Foldes", "Bill Loney", "Billy Rubin", "Bob Apple", "Bob Katz", "Bonnie Ann Clyde", "Bonnie Beaver", "Brad Hammer ", "Brandon Cattell", "Brandy Anne Koch ", "Brandy D. Cantor", "Brighton Early", "Brock Lee", "Brooke Trout", "Bud Light", "Bud Wieser ", "Buster Cherry", "C. Good ", "C. Senor", "C. Worthy", "C. Write ", "Cam Payne", "Candace Spencer ", "Candy Barr", "Cara Sterio ", "Cara Van", "Carrie Dababi ", "Carrie Oakey", "Casey Macy", "Charity Case", "Cheri Pitts", "Chip Munk", "Chip Stone ", "Chris Coe", "Chris Cross", "Chris P. Bacon", "Chuck U. Farley", "Chuck Waggon", "Claire Annette Reed", "Constance Noring", "Corey Ander", "Corey O. Graff", "Count Dunn", "Coyne Flatt ", "Craven Moorehead", "Crystal Ball ", "Crystal Claire Waters", "Crystal Glass", "D. Kay", "D. Liver", "Dan D. Lyons", "Dan Druff", "Dan Saul Knight", "Darren Deeds", "Daryl Rhea", "Dear Beloved ", "Dick Bender ", "Dick Burns", "Dick Bush ", "Dick Face", "Dick Finder ", "Dick Handler", "Dick Hardigan ", "Dick Head", "Dick Hyman ", "Dick Hunter ", "Dick Long", "Dick Mussell", "Dick Pole ", "Dick Pound", "Dick Rasch ", "Dick Swett", "Dick ", "Dick Tator", "Dick Trickle ", "Dick Wood ", "Dickson Yamada", "Dilbert Pickles", "Dinah Soares", "Dixon", "Don Key", "Donald Duck", "Donny Brook", "Doris Schutt ", "DooLittle & Dalley ", "Doug Graves", "Doug Hole", "Doug & Phil Updegrave ", "Doug Witherspoon", "Douglas Furr", "Dr. Baldock ", "Dr. Croak", "Dr. Harry C. Beaver ", "Dr. Bender ", "Dr. Butcher", "Dr. DeKay", "Dr. & Dr. Doctor ", "Dr. Fang ", "Dr. Shelly Fingerhood ", "Dr. Gass ", "Dr. Gutstein", "Dr. Hanus", "Dr. Hurt ", "Dr. Hymen", "Dr. I. Ball ", "Dr. Kauff", "Dr. Killum", "Dr. Look ", "Dr. Looney - a psychiatrist of course!", "Dr. Payne ", "Dr. Pullham", "Dr. Robert Fallis ", "Dr. Slaughter", "Dr. Surgeon ", "Dr. E. Ville", "Drew Peacock", "Duane Pipe", "Dusty Carr", "Dusty Sandmann ", "Edna May ", "Earl E. Bird", "Earl Lee Riser", "Easton West ", "Eaton Wright and Liv Good", "Eddie Current ", "Edward Z. Filler", "Ella Vader", "Emma Royds", "Eric Shinn", "Ernie Coli ", "Estelle Hertz ", "Evan Keel", "Faith Christian","Fanny O'Rear","Father A. Long", "Ferris Wheeler", "Flint Sparks", "Fonda Dicks ", "Ford Parker", "Forrest Green", "Foster Child", "Dr. Frank Bonebreak ", "Frank Enstein", "Dr. Franklin Stein ", "Gae Hooker ", "Gaye Barr", "Gaye Jolly ", "Gail Force", "Gail Storm ", "Gene Poole", "Geoff L. Tavish ", "Gil Fish", "Ginger Rayl", "Gladys C. Hughes ", "H. Wayne Carver", "Hamilton Burger ", "Harden Thicke", "Harold Assman ", "Harry Armand Bach", "Harry Baals ", "Harry Beard", "Harry Caray ", "Harry Chest", "Harry R. M. Pitts", "Harry Rump ", "Hazle Nutt", "Heidi Clare", "Helen Back", "Helen Waite ", "Helen Wiells ", "Herb Farmer", "Holly McRell", "Holly Day", "Honey Bee", "Howie Doohan", "Hugh Jass", "Hugh Jorgan", "Hugh Morris ", "Hy Ball", "Hy Lowe", "Hy Marx ", "I.D. Clair", "I. Lasch", "I.M. Boring", "I.P. Freely", "I. Pullem ", "Ileane Wright", "Ima Hogg ", "Iona Ford", "Iona Frisbee ", "Iona Stonehouse ", "Isadore Bell ", "Ivan Oder", "Ivana Mandic ", "Ivy Leage", "Jack Hoff", "Jack Goff ", "Jack Haas", "Jack Hammer", "Jack Knoff", "Jack Pott", "Jack Tupp ", "Jacklyn Hyde", "Jasmine Rice ", "Jay Walker", "Jean Poole", "Jed Dye ", "Jenny Tull", "Jerry Atrick", "Jim Laucher ", "Jim Shorts", "Jo King", "Joe Kerr ", "Jordan Rivers", "Joy Kil", "Joy Rider", "June Bugg", "Justin Case", "Kandi Apple", "Katherine ", "Kay Bull", "Keelan Early ", "Kelly Green", "Ken Dahl", "Kenny Penny", "Kent C. Strait ", "Kenya Dewit", "Kerry Oki", "King Queene", "Lake Speed ", "Lance Boyle", "Laura Lynne Hardy", "Laura Norder ", "Laurence Getzoff", "Leigh King ", "Les Moore", "Les Payne - should be an anesthesiologist", "Les Plack", "Levon Coates", "Lewis N. Clark ", "Lily Pond", "Lina Ginster ", "Lindsay Doyle ", "Lisa Carr", "Lisa Ford", "Lisa May Boyle", "Liv Long", "Lois Price ", "Lou Pole", "Lou Zar ", "Luckey", "Lucy Fer", "Luke Warm", "Lynn C. Doyle", "Lynn O. Liam", "M. Balmer", "Macon Paine ", "Mark Skid ", "Manny Kinn", "Marlon Fisher", "Marsha Dimes ", "Marsha Mellow", "Marshall Law", "Marty Graw", "Mary Annette Woodin", "Mary A. Richman", "Mary Christmas", "Matt Tress", "Maude L.T. Ford", "Max Little", "Max Power", "May Day", "May Furst", "Mel Loewe", "Melba Crisp ", "Melody Music", "Mia Hamm ", "Mike Easter", "Mike Hunt", "Mike Raffone", "Mike Reinhart ", "Mike Rotch", "Mike Stand ", "Mike Sweeney ", "Milly Graham", "Minny van Gogh", "Missy Sippy ", "Mister Bates", "Misty Waters ", "Misty C. Shore ", "Mo Lestor", "Moe B. Dick", "Moe DeGrasse", "Molly Kuehl", "Mona Lott", "Monica Monica ", "Morey Bund", "Morningwood Drive ", "Muddy Waters ", "Myles Long", "Nancy Ann Cianci", "Nat Sass", "Neil Down", "Neil McNeil ", "Nick O. Time", "Noah Riddle", "Norma Leigh Lucid", "Olive Branch", "Olive Green", "Olive Hoyl", "Olive Yew ", "Oliver Sutton ", "Ophelia Payne", "Oren Jellow", "Orson Carte", "Oscar Ruitt", "Otto Graf", "Owen Big", "P. Ness", "P. Brain", "Paige Turner", "Park A. Studebaker", "Pat Downe ", "Pat McCann", "Pat Hiscock", "Patience Wait ", "Patton Cox", "Pearl Button", "Pearl E. Gates", "Peg Legge", "Penny Dollar", "Penny Lane", "Pepe Roni", "Pete Moss and his son Forest", "Peter Johnson ", "Peter Peed", "Peter Wacko", "Phil Bowles ", "Phil Graves ", "Phil Rupp", "Phil Wright", "Phillip D. Bagg ", "Pierce Cox ", "Pierce Deere", "Pierce Hart", "Polly Ester", "Post", "Price Wright ", "Priti Manek ", "R. M. Pitt", "R. Sitch", "R. Slicker", "Randy Guy", "Randy Lover", "Raney Schauer", "Ray Gunn", "Ray Zenz ", "Raynor Schein", "Reid Enright", "Rex Easley ", "Rhea Curran", "Rhoda Booke", "Rich Feller", "Richard P. Cox ", "Richard Chopp ","Rick O'Shea","Rick Shaw", "Rip Torn ", "Rita Buch", "Robin Andis Merryman", "Robin Banks", "Robert and Reginald Soles ", "Rock ", "Rocky Beach", "Rocky Mountain", "Rocky Rhoades", "Rod N. Reel", "Roman Holiday", "Rose Bush", "Rowan Boatman", "Royal Payne", "Russell Leeves", "Russell Sprout", "Rusty Blades", "Rusty Irons", "Ryan Carnation", "Ryan Coke ", "Sal A. Mander", "Sal Minella", "Sally Forth", "Sarah Bellum", "Sawyer B. Hind", "Sandy Banks", "Seth Poole ", "Seymour Bush ", "Shanda Lear ", "Sharon Fillerup", "Sharon Needles", "Sheila Blige", "Skip Roper", "Sonny Day", "Sno White ","Stanley Cupp", "Dr. Steven Sumey ", "Sue Flay", "Sue Render ", "Sue Ridge ", "Sue Yu", "Summer Camp ", "Sy Burnette", "Tad Moore", "Tad Pohl", "Tamara Knight", "Tanya Hyde", "Tara Cherry", "Ted E. Baer", "Terry Achey ", "Terry Bull ", "Tess Steckle", "Therese R. Green", "Thomas Richard Harry", "Tiffany Box ", "Tim Burr", "Tish Hughes", "Tittsworth & Grabbe", "Tom A. Toe", "Tom Katt", "Tom Morrow", "Tommy Gunn", "Tommy Hawk", "Trina Woods", "Ty Coon", "Urich Hunt", "Viola Solo", "Virginia Beach", "Walter Melon", "Wanda Rinn", "Wanna Hickey", "Warren Peace", "Warren T.", "Will Power", "Will Race ", "Will Wynn ", "Willie B. Hardigan", "Willie Leak ", "Willie Stroker", "Willie Waite", "Winsom Cash", "Woody Forrest", "X. Benedict"};
    private int randUser = 0,randNumber=0;
    String name = "";



    public UserServiceMongoDB( @Autowired UserRepository userRepository,@Autowired FacadeRepository facadeRepository)
    {
        this.facadeRepository = facadeRepository;
        this.userRepository = userRepository;
    }
    @Override
    public User create(UserDto user) throws UserException {
        Random rand = new Random();
        name = "";
        randNumber = rand.nextInt((nombres.length ) + 1);
        int x = rand.nextInt((nombres.length ) + 1);
        name += nombres[randNumber] + Integer.toString(x);
        User user1 = new User(user);
        user1 = userRepository.save(user1);
        UserFacade u = new UserFacade(name, "/photoStandar.jpg",user1.getId(),new ArrayList<String>(Arrays.asList("#FireBox")));
        facadeRepository.save(u);

        return user1;

    }

    @Override
    public User findById(String id) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserException("Not Found");
        }
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) throws UserException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(UserDto user, String userId) throws UserException {
        if(userRepository.findById(userId).isPresent()){
            User u = userRepository.findById(userId).get();
            u.update(user);
            userRepository.save(u);
            return u;
        }
        return null;
    }

    @Override
    public User updatePhoto(String photo, String userId) throws UserException {
        if(userRepository.findById(userId).isPresent()){
            User u = userRepository.findById(userId).get();
            u.setFoto(photo);
            userRepository.save(u);
            return u;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) throws UserException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException(UserException.USER_NOT_FOUND);
    }
    @Override
    public List<User> findByUniversidadGenero(String universidad, String genero)  {
        List<User> lista=userRepository.findByUniversidadAndAndGenero(universidad, genero);
        /*List<User> listaUniversidad=new ArrayList<User>();
        for (User u : lista){
            if(u.getGenero().equals(genero) && u.getUniversidad().equals(universidad)){
                listaUniversidad.add(u);
            }
        }*/
        return lista;
    }

    public List<User> findByUniversidad(String universidad)  {
        List<User> lista=userRepository.findByUniversidad(universidad);
        return lista;
    }

    //Match Services

    @Override
    public void addUserRequest(String userId, String userIdToAdd) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent() || !userRepository.findById(userIdToAdd).isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        User user = optionalUser.get();

        //Verify request is by a Friend
        if(user.getUserFriends().contains(userIdToAdd)){
            throw new UserException(UserException.USER_IS_ALREADY_FRIEND);
        }

        //Save actual Request List into DB
        user.getUserRequests().add(userIdToAdd);
        userRepository.save(user);
    }


    @Override
    public void deleteUserRequest(String userId, String userIdToDelete) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent() || !userRepository.findById(userIdToDelete).isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();

        //Remove userToDelete from UserRequest
        user.getUserRequests().remove(userIdToDelete);

        //Save actual Request List into DB
        userRepository.save(user);
    }

    @Override
    public void deleteUserFriend(String userId, String userIdToDelete) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<User> optionalUserToDelete = userRepository.findById(userIdToDelete);
        if(!optionalUser.isPresent() || !optionalUserToDelete.isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();
        User userToDelete =  optionalUserToDelete.get();

        //remove both users to each other
        user.getUserFriends().remove(userIdToDelete);
        userToDelete.getUserFriends().remove(userId);

        //Save actual Request List and Friends List into DB
        userRepository.save(user);
        userRepository.save(userToDelete);
    }

    @Override
    public void addUserFriends(String userId, String userIdToAdd) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<User> optionalUserToAdd = userRepository.findById(userIdToAdd);
        if(!optionalUser.isPresent() || !optionalUserToAdd.isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();

        //Verify if is already friend
        if(user.getUserFriends().contains(userIdToAdd)){
            throw new UserException(UserException.USER_IS_ALREADY_FRIEND);
        }

        //Verify if a request was sent before try to add as friend
        if(!user.getUserRequests().contains(userIdToAdd)){
            throw new UserException(UserException.USER_NO_IN_REQUEST);
        }
        User userToAdd =  optionalUserToAdd.get();

        //Remove users from UserRequest in case both send the request
        user.getUserRequests().remove(userIdToAdd);
        userToAdd.getUserRequests().remove(userId);

        //Add both users to each other
        user.getUserFriends().add(userIdToAdd);
        userToAdd.getUserFriends().add(userId);

        //Save actual Request List and Friends List into DB
        userRepository.save(user);
        userRepository.save(userToAdd);

    }

    @Override
    public HashSet<String> getAllRequestByUserId(String userId) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        return optionalUser.get().getUserRequests();
    }

    @Override
    public HashSet<String> getAllFriendsByUserId(String userId) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        return optionalUser.get().getUserFriends();
    }


    //End Match Services

    @Override
    public List<User> findSomeById(List<String> usersId) throws UserException {
        List<User> users = new ArrayList();
        for(String id : usersId){
            users.add(findById(id));
        }
        return users;
    }


}
