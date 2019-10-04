# WeatherBase #
The WeatherBase App display weather based on selected position on the map with a provision to bookmark selected places on the map and also complete weather details.

## Features ##
- HomeScreen which displays a list of favorite city with a delete button on each displayed city to remove if required.
- Homescreen has two floating button.
  - Add location---when clicked navigates to the map screen that allow user to select any location on the map. Once selected you need to click on the favorite icon on the Toolbar to add the location to the favorite screen.
  - Go to Helpscreen--- when clicked it helps you navigate to help screen which display some basic information about the app.
  - In the Home screen when clicked on the city list items, it displays the Details weather screen of the selected city.
  -  Details Screen contains below details
     - selected city name
     - Temperature details.
     - Last updated temperature updated time.
     - Min and Max temperature.
     - Sunrise, sunset time.
     - Wind speed.
     - Pressure value.
     - Humidity value.
     - Weather forecast would be a future work on this app to add details of weekly/hourly forecast
      

## APIs
OpenWeatherMap API
http://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=c6e381d8c7ff98f0fee4377 5817cf6ad&units=metric 

** Please update the API key as instructed below to see the Google Maps function correctly **
**Update API Keys** 🔑
 - Please create a API Key and udpate it in build.gradle(module:app) in buildTypes section.
 
## WeatherBas APP

<ul>
  <li>Home Screen</li>
  <li>Map Screen </li>
  <li>Details Screen</li>
  <li>Help Screen </li>
  </ul>
 
  <div style="text-align: center">
    <table>
        <tr>
            <td style="text-align: center">
                    <img src="https://github.com/kamalshree/WeatherBase/blob/master/app/src/main/assets/Screenshot_20191004-002419.png" width="200"/>
            </td>            
            <td style="text-align: center">              
                    <img src="https://github.com/kamalshree/WeatherBase/blob/master/app/src/main/assets/Screenshot_20191004-002427.png" width="200"/>
            </td>
            <td style="text-align: center">
                    <img src="https://github.com/kamalshree/WeatherBase/blob/master/app/src/main/assets/Screenshot_20191004-002435.png" width="200" />
            </td>      
           <td style="text-align: center">
                    <img src="https://github.com/kamalshree/WeatherBase/blob/master/app/src/main/assets/Screenshot_20191004-002839.png" width="200" />
            </td>   
      </tr>
  </table>
  </div>
  
 - App is  responsive and can be viewed perfectly on (landscape and portrait orientations, 
