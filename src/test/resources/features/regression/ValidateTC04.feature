Feature: To Validate TestCase four
@all @regression
Scenario: Verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel

Given User should start "chrome" 
And user should open the app using url "https://adactinhotelapp.com/SearchHotel.php"
When user enters username "reyaz0806" by using xpath "//input[@name='username']"
And user enters password "reyaz123" by using xapth "//input[@name='password']"
Then user clicks on button using xapth "//input[@name='login']"
And user verifies the title "Adactin.com - Search Hotel"
Then user enters details in search hotel form

| location | hotel | checkin date | room type | no of rooms | check out date | adults | children | check out error |
| Sydney | Hotel Creek | 20/04/2025 | Standard | 1 - One | 25/04/2025 | 1 - One | 0 - None | Check-Out Date shall be after than Check-In Date |
Then User submit the form
Then User verifies the hotel name in select hotel page

| location | hotel | checkin date | room type | no of rooms | check out date | adults | children | check out error |
| Sydney | Hotel Creek | 20/04/2025 | Standard | 1 - One | 20/04/2025 | 1 - One | 0 - None | Check-Out Date shall be after than Check-In Date |
