class Problem1 extends ConsoleProgram {

  /**
  * Description
  * @author:
  */
  
  public void run() {
    System.out.println("***** Student Account Registration *****");
    String firstName = readLine("Enter your first name:  ");
    String lastName = readLine("Enter your last name:  ");
    String studentID = readLine("enter your student number:  ");
    String username = readLine("Enter a new username:  ");
    Errors(firstName, lastName, studentID, username);
    System.out.println("\nValid username: " + validateUsername(username) );
    System.out.println("Your password is: " + createPassword(firstName, lastName, studentID) );
  }

  /**
   * determins if the username is valid or invalid.
   * 
   * @param username the inputed username by the user.
   * @return whether or not the username is valid or invalid (boolean)
   */
  public boolean validateUsername(String username){
    char character;
    int digits = 0;

    for (int i = 0; i < username.length(); i++){
      character = username.charAt(i);
      if(!Character.isLetterOrDigit(character) ){
        return false;
      }
      if(Character.isDigit(character) ){
        digits++;
      }
    }
    if (username.length() <= 7 || digits == 0){
      return false;
    }
    return true;
  }

  /**
   * creates a password based on the user's inputs.
   * 
   * @param firstName user's first name.
   * @param lastName user's last name.
   * @param studentNumber user's student ID.
   * @return the newly created password.\
   */
  public String createPassword(String firstName, String lastName, String studentNumber){
    String password = "";
    if (lastName.length() < 4){
      password += lastName.toLowerCase();
    } else {
      password += (lastName.substring(0, 4) ).toLowerCase();
    }
    password += Character.toUpperCase(firstName.charAt(0) );
    password += studentNumber.substring(3,6);
    return password;
  }

  /**
   * catches exceptions and errors in user's inputs.
   * 
   * @param firstName the inputed first name.
   * @param lastName the inputed last name.
   * @param studentID the inputed studentID.
   * @param username the inputed username.
   */
  public void Errors(String firstName, String lastName, String studentID, String username){
    boolean  error = false;
    if (firstName.length() <= 0 || lastName.length() <= 0 || username.length() <= 0){
      error = true;
    }
    if (studentID.length() != 9){
      error = true;
    }
    if (error){
      throw new ArithmeticException("incorrect parameter(s)");
    }
  }
}