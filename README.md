# Advance-java-problem-solving
Problem Solving in advance java topics such as hibernate, spring boot etc.

Day 1
1. Before revision , ensure DB connectivity using DBUtils (singleton pattern) & tester code

2. Import day1.1 project in your workspace.
Edit JDBC JAR (with lab faculty's help) from build path
Use this project for your reference.
(revise JDBC steps completely)

3. Write  customer login & registration.

3.1 Copy customers table & data in your DB. (ref : day1-data\day1_help\jdbc help\sql\bookshop sql.txt)

3.2 Create DBUtils & Tester for the following

1. User Login
I/P email n passsord
O/P In case of success : display complete customer details . In case of invalid login : error mesg


2. New User registration
I/P all details (except customer id , since customer id is auto inc)
O/P message (registration success or failed)


4. For testing Cloning : refer to ready code (day1-data\day1_help\ready code\test_cloning)
With help of lab faculty , understand : 
shallow copy
deep copy

5. Reading H.W
5.1 Read day1-data\day1_help\jdbc help\SQL injection\regarding SQL injection
5.2 Object class methods wait & notify
5.3 Revise ITC

Day 2

0.First  ensure that , you have added Tomcat web server in your J2EE workspace & you have created n tested 1st dyn web project m having index.html content
(refer to day2-data\day2_help\common help\steps in tomcat.txt)

Revise class work.(by importing day2.1)

1. JDBC assignment (MUST be done using layered approach)
(refer to diag : day2-data\day2_help\case studies\voting assignment.png)

Layers
1.1 Table : voters & candidates (copy them from day2-data\day2_help\sql\my_sql_cmds_voting.txt)
1.2 POJOs : Voter & Candidate
(POJO : state , def constr, parameterized constr, setters/getters,toString)
1.3 DAO : IVoterDao , ICandidateDao & implementation classes.
IVoterDao
Voter authenticateVoter(String em,String pwd) throws SE
String updateVotingStatus(int voterId) throws SE

VoterDaoImpl
state : cn ,pst1
def constr : get cn from utils , create pst1
CRUD methods : 
public Voter authenticateVoter(String em,String pwd) throws SE
{
  1. set IN params : 2
  2. execQuery --RST --if(....) return new Voter(...);
   return null;
}
clean up

1.4 ICandidateDao
String registerCandidate(String name,String party) throws SqlExc
String updateVotes(int candidateId) throws SqlExc

CandidateDaoImpl
state : cn , pst1
def constr : get cn , pst1 : "insert into candidates values(default,?,?,0)"

CRUD methods : 
public String registerCandidate(String name,String party) throws SqlExc
{
  //set IN params , execUpdate ---> updateCount --1 --chk n ret sts mesg.
}


cleanup : close pst1





1.4 Tester
try(sc) 
{exit=false;
  instantiate VoterDao, CandidateDao 
  while --try --switch case 
}catch-all

Options
1. Voter login
i/p : email & password
o/p status mesg
Voter login successful, Your details ....

2. Candidate registration
i/p candidate details excluding id & votes (Accept name & party from user. id will be generated in auto-increment manner  & initialize votes=0)
o/p : status message

3. List all candidates

4. Cast a Vote
i/p : candidate id & voter id
Action : inc candidate's votes & change voting status to true.
o/p status mesg
(Hint : invoke  2 separate methods  on 2 different daos : Voter Dao n Candidate Dao)

Mandatory reading 
1. HTTP basics
2. web basics


Day 3
With lab facutly's  help : 
1. Understand how to  import existing dynamic web project n fix errors if any 

2.Identify all possible clean up instructions , in case of errors

Do the revsion , along with hands-on today.
Create a new dynamic web project (check web.xml checkbox) : eg day3_lab1
Solve following
3. Create a welcome page : index.html
Add a link : to invoke the servlet (which will be deployed using @WebServlet annoatation)

Create FirstServlet.java , override life cycle methods & trace the life cycle.
Use @WebServlet annoatation . WC should load this servlet lazily.

4. Add another link in index.html : to invoke the servlet (which will be deployed using xml tags)

Create SecondServlet.java , override life cycle methods & trace the life cycle.
Do NOT Use @WebServlet annoatation , instead add xml tags in web.xml
 . WC should load this servlet eagerly

5. Add / in anchor tag's href. Observe n conclude

6. Remove / from the url-pattern . Observe n conclude

7. Give same url-pattern to both of these servlets . Observe n conclude

8. Copy input.html from "day2-data\day2_help\HTML pages" , under webapp
Write a servlet to send followoing response to the clnt
Hello , user name
Favorite Colors : ...
Chosen Browser : ..
Selected City : 
About Yourself : 

API Help (refer to Java EE docs fro further clarity)

How to read request params sent from the clnt ?

javax.servlet.ServletRequest i/f methods
1. public String getParameter(String paramName)

2. public String[] getParameterValues(String paramName)
 

Day 4
Revision
1. import day4.2 in your workspace , replace DBUtils by yours.
Trace the entire flow , to understand
1.1 cookie based session tracking 
1.2 redirect

Observe the changes if cookies are not accepted by the client browser.
Everything MUST be confirmed using "Inspect" of clnt browser (web dev tools)

2. import day4.3 in your workspace , replace DBUtils by yours.
Trace the entire flow , to understand
2.1 HttpSession based session tracking 
2.2 redirect

Observe the changes if cookies are not accepted by the client browser.
Everything MUST be confirmed using "Inspect" of clnt browser (web dev tools)

3. Create new dyn web project : day4_lab
Start working on "voting assignment" , as per the page flow , supplied in case studies.
(For session tracking : use HttpSession API)
3.1 Copy pkges : utils, pojos,dao , under <src>/main/java
3.2 web.xml : welcome-file : login.html
3.3 Copy login.html : <src>/main/webapp
form action="voter_validate" , method=post
3.4 VoterAuthServlet : eager
init,destroy,doPost
init : voter dao inst
destroy : dao's cleanup(psts :close) , utils: closeConnection
doPost : refer to the flowchart (voting-assgnment-help1.png)

3.5 Copy Candidate pojo n Candidate dao.
Refer to <day4-data>/day4-help/voting assignment help2.png

Day 5
1. import day5.1 in your workspace , edir DBUtils & trace entire flow from login to logout.

2. Complete voting assignment
(At least voter part . After completing voter role , do complete admin role)

Day 6
Mandatory Work
1. Complete voting assignment including voter n admin role.

2. Revise 
Servlet life cycle , ServletConfig , init-params , executor frmwork & server pull.
Import today's projects n revise the flow.

3. Optional assignment will be shared later.
Refer to Online Bookshop assignment (refer to case study diagram)
3.1 Add ShowCartServlet
Since contents of ShowCartServlet & CheckOutPage are mostly the same, DO NOT repeat !
create a common page : CartContentsPage(to greet user n display cart contents n total cart value)
Use RequestDispatcher's include scenario , to dynamically include the contents of CartContentsPage into ShowCartServlet & CheckOutPage.

3.2 Add "Register" button or a link in login.html. Complete customer registration part as per the case study diagram.

3.3 After customer logs out , instead of giving him/her "Visit Again" link , navigate the client auto to login page after delay of 10sec.
(Hint : 

3.4 More Complex one!
Objective : After user checks out the cart (i.e visits "LogoutPage") , the order & order details should be added suitably in DB.
Hints 
1. Refer to DB tables n ER diagram from "day1-data\day1_help\jdbc help\sql"

2. Create additional POJOs  for Order n OrderLine (i.e order details)

3. Create new DAO layer's class OrderDao
& add a method to check out the cart(i.e store order n it's details in DB)

Day 7
1. Import day7.2 & revise JSP syntax
(using "day7-data\day7_help\jsp_help\readme_jsp.txt")

2. Refer to JSP declaration tag from above readme.
Complete the assignment with the help of lab faculty 
(day7-data\JSP assignment .png)

3. Complete DAO layer of (day7-data\candidate-registration.png) 
Will be solving this assginment tomorrow , using JSP & JavaBean

4. Complete pending work.

Day 8
1. import day8.2 & revise completely JSP--JavaBean--DAO--POJO--DB flow.
(use readme_jsp for better clarity & refer to  JSP --JB diagrams)

2. Identify "double submit issue" with server pull & replace it by client pull
(JSTL tags)

3. Solve assignment of registering new candidate under "admin" role (with lab faculty's help)
(refer : candidate-registration.png)

4. Refer to  "day8_data\maven\maven instructions for Java SE with Hibernate.txt" OR import "day8_data\maven\test_hibernate_maven" , as existing maven project.


Day 9
1. Complete the following (in a combined lab)
1.1  Persist user information

1.2 Get user details by PK

1.3 Get all user details. (PENDING!!!)

---------------
1.4 Revise class work by importing day8.4 (a web app) in your workspace & trace all the layers
JSP--JavaBean --JDBC Based DAO(DBUtils)--POJO --DB

1.5 Refer to "day9_data\day9_help\ready code\jstl_demo" : It's a web app , a demo of JSTL tags.

1.6 Revise steps in creating hibernate based project.

Hands on 

2. Create Maven based hibernate project from scratch OR copy it from template project supplied here
"day9_data\eclipse_projects" & edit hibernate.cfg.xml as per your own DB settings.

2.1 Test booting up hibernate framework

2.2 Create a Vendor POJO with following state.
id (Long) ,  name (string) , email  (string : unique) , password(string) : NOT NULL  ,regAmount (double) , regDate (LocalDate)
Add JPA annotations

2.3 Check auto table creation

2.4 Create hibernate based DAO layer n testers for the following
Insert atleast 3 vendor details (using session.save)


2.5 Get vendor details by vendor id.
---------------------------------------------
Later : 
2.5 Get all vendor details

2.6 Update reg amount 
--------------------
Important revision topics(to go over through weekend)
1. Servlet life cycle
2. Session Tracking (HttpSession based)
3. Page Navigation techniques : redirect n RD's forward
4. JSP --JB --DAO --POJO --DB
5. JSTL tags : redirect , forEach,url,if,choose/when/otherwise


Day 10
1. Complete more objectives (update , delete in a combined lab)

2. Revise class work completely.

3. Complete CRUD work for Vendor
3.1 Register New Vendor
I/P : all vendor details excluding vendor id
O/P a message indicating success or failure
eg : String registerVendor(Vendor vendor);
session.save

3.2 Vendor Login 
I/P email , password
O/P : Login successful with vendor details or invalid login message.
eg : String authenticateVendor(String email,String pwd);
jpql="select v from Vendor v where v.email=:em and v.password=:pass";
Vendor v=session -- createQuery(jpql,Vendor.class).setParameter(....).setParameter(....).getSingleResult(); --- throws NoResultException ---invalid login


3.3 Update vendor's reg amount
I/P : email , reg amount offset
O/P a message indicating success or failure
eg : String updateRegAmount(email,offset)
jpql="select v from Vendor v where v.email=:em"
Vendor v=session -- createQuery(jpql,Vendor.class).setParameter(....).getSingleResult();
v : persistent
setter....
commit

3.4 Delete all vendor details whose reg amount < specified amount & registered after specific date.
I/P : reg amount n reg date
O/P a message indicating success or failure
eg : Bulk deletion
jpql ="delete from Vendor v where ....."
int count=session. createQuery(jpql).setParameter(....).setParameter(....).executeUpdate();


OR
Complete DAO / POJOs for the voting assignemnt with "admin" role or "voter" role



Day 11
In combined lab : 
1. Identify n Solve lazy init issues .
2. Create one to one bi directional association , with shared primary key , between Student & Address.
3. Replace it by uni dir , for reducing no of queries.


3. Revise class work
1.1 import day11.1 , to revise Blob handling
1.2 import day11.2 , to revise one to many & one to one bi directional association between entities.

4.Hands on (Mandatory)
4.1 Create Vendor 1<---->* BankAccount , bi directional one to many association
4.2 Create Vendor 1<----Location , uni dir one to one association.
Optional
4.3 Create Topic 1 <-----* Tutorial , uni directional  many to one association



Day 12
In a combined lab : 
1. Create maven based spring application (Java SE based) , to demo setter based D.I & spring beans life cycle.
(copy it from the template)

2. Refer to "web-app-hibernate-integration-assgnment" , from day12-data
Start with the design part .

3. Replace setter based D.I by constructor based D.I (if time permits , in the combined lab)

4. Complete the implementation of "web-app-hibernate-integration-assgnment"  in the individual labs. Revise complete class work.

Optional work
5. Refer to Vendors-ER-Diag , from day12-data.
Complete POJO's design from the supplied diagram.

Day 13
1. Revise spring bean life cycle , modes of wiring , by importing day13.1 to day13.6 projects
day13.1 : spring bean life cycle with setter based D.I(Look at all interfaces , classes , TestSpring & bean config xml file)
Next time onwards : simply open dependent bean & xml file
day13.2 : constr based D.I
day13.3 : factory method based D.I
day13.4 : autowiring byName
day13.5 : autowiring byType
day13.6 : autowiring  constructor

2. Replace bulk of XML by annotations , use hybrid approach .

3. Complete pending work.

Day 14 
Create maven based web app (w/o spring boot) with Spring MVC & Hibernate , to start solving vendor case study.

Day 15
Revise n implement spring boot MVC from scratch.

Day 16
1. Revise n implement RestController for building full stack app.

2. Optional assignment
Refer to : day16-data\full stack assignment\react front end\react-tut-app
npm install 
Understand the flow n develop the backend for this ready made react app.

Day 17
1. Complete objectives discussed in the sequence earlier.
2. Develop distributed apps , user-app invoking REST API of net banking server , using RestTemplate.


