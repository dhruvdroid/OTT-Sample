# Sample OTT

Used the following concepts
1. MVVM architecture
2. Koin dependency injection
3. Coroutines for multiple threaded and different scope operations
4. View binding for xml file binding in UI components (Activity)
5. Retrofit for rest API calls
6. Gson for JSON data conversion
7. Android architecture component (Live Data, View Model, Repository etc)
8. Kotlin extention components
9. Material libraries
10. Used the webp images to decrease the size of Apk instead of jpeg or png

**Know Issues**
1. Loading indicator via Movie Result Sealed classes
2. Error handling for no network and empty list while filtering
3. Instead of giving the fixed coloumn (3 - portrait / 7 - landscape) for the Grid Layout. I have
opted for the width based deciding of the coloumn

**Improvements**
1. Using of the navigation component, didn't used it as there was not much of the navigation inside
 the application it would be miuch easier way to implement
2. Didn't use PAGING library for Pagination (Jetpack) because of limitation of the API data
3. Choose Koin over Dagger as I am currently working with Dagger wanted to learn the Koin
implementation and learn something new. If I would have given choice to choose DI, I would have tried
out the HILT (Reason - out of the box support by android team and testing capability)
4. Implementation of the ROOM to save the user data, and cache to avoid the API call.
5. Inclusion of uni test, couldn't complete it because of my pet medical emergency.