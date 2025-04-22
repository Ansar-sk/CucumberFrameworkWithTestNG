Feature: Validate Login functionality
@wip123 @all

Scenario: Validate login using different credentials
Given User should start "chrome"
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"
When user enters username "reyaz0806" by using xpath "//input[@name='username']"
And user enters password "reyaz123" by using xapth "//input[@name='password']"
Then user clicks on button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Search Hotel"
