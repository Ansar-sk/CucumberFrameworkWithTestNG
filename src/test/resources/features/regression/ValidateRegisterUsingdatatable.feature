Feature: Validate Login functionality
@wip123 @all
Scenario: Validate login using different credentials
Given User should start "chrome"
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"
Then user clicks on button using xapth "//a[text()='New User Register Here']"
And user enter details in registration form
| username | password | re-password | fullname | mail|
| validtest | test123 | test123 | testuser | validate@gmail.com|