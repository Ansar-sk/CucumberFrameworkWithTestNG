Feature: Validate login functionalities using paramaeterizartion
@all
Scenario Outline:
To validate login using multiple credentials

Given User should start "chrome"
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"
When user enters username '<Userid>' by using xpath "//input[@name='username']"
And user enters password '<Password>' by using xapth "//input[@name='password']"
Then user clicks on button using xapth "//input[@name='login']"
And user verifies the title '<ExpTitle>'


Examples:
| Userid | Password | ExpTitle |
| reyaz0806 | reyaz123 | Adactin.com - Search Hotel |
| reyaz1212 | reyaz123 | Adactin.com - Hotel Reservation System |
| reyaz0806 | reyaz000 | Adactin.com - Hotel Reservation System |