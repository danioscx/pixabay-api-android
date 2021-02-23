# pixabay-api-android
unofficial Pixabay api for android

## installation
Download this repository 
```github
git clone https://github.com/danioscx/pixabay-api-android.git
```
after download open your android studio then click File->New->Import module 
then locate this repo

### How to use 
making new image request
```Java
Pixabay pixabay = Pixabay.getInstance(requireContext())
                .apiKey(API_KEY)
                .editorChoice(true)
                .colors(Colors.BROWN);
```
