Feature: To validate user registration
@all
Scenario: Validate new user registration

Given User should start "chrome"
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"
When user clicks on register user using xpath "//a[text()='New User Register Here']"
When user enters username '<Username>' by using xpath "//input[@name='username']"
And user enters password "<Password>" by using xapth "//input[@name='password']"
And user re-enters password "<Password>" by using xapth "//input[@name='re_password']"
And user enters fullname "<Fullname>" by using xapth "//input[@name='full_name']"
And user enters text "<Email>" by using xapth "//input[@name='email_add']"
Then user clicks on checkbox using xapth "//input[@name='tnc_box']"

Examples:
| Username | Password | Fullname | Email | 
| test | test123 | test123 | valid123@gmail.com |
