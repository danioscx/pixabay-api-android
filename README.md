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
making new simple image request
```Java
Pixabay pixabay = Pixabay.getInstance(requireContext())
                .apiKey(API_KEY)
                .editorChoice(true)
                .colors(Colors.BROWN);
```
implementation your request into default model <br />
you don't need create model just put Images class in your recyclerview adapter or listview adapater
```Java
pixabay.setOnPixabayImageRequest(pixabay, new Pixabay.OnPixabayImageRequest() {

            @Override
            public void onResult(List<Images> images) {
                // attach your recycler view here
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: " + error);
            }
        });
```
Making new simple video request 

```Java
Pixabay.Video video = new Pixabay.Video(requireContext())
                .apiKey(API_KEY)
                .videoType(VideoType.ANIMATION);
```
implement video request <br />
same with request images you don't need create model all has been set in library.

```Java
video.setOnPixabayVideoRequest(video, new Pixabay.Video.OnPixabayVideoRequest() {

            @Override
            public void onResult(List<io.github.pixabay.model.Videos> videos) {
               //attach your recycler view here
            }

            @Override
            public void onError(String error) {

            }
        });
        
```

making new request with custom model

``Java
Pixabay pixabay = Pixabay.getInstance(requireContext())
                .apiKey(API_KEY)
                .editorChoice(true)
                .colors(Colors.BROWN);
```
implement request

```Java
video.setOnPixabayVideoRequest(video, new Pixabay.Video.OnRequestResponse() {
            @Override
            public void onResult(JSONObject response) {
                //working your custom model here
            }

            @Override
            public void onError(String error) {

            }
        });

```

