
# Rapport

Det första som jag behövde göra var att skapa en RecyclerView. detta gjordes genom att skapa en RecyclerView widget i activity main.
Sedan så skapades en ny layout fil med en textview. sedan så skapade jag en ny java fil som representerar items, java filen heter recyclerviewitem.

Sedan så Deklarera och initiera en adapter med denna kod. Denna kod lägger även till en onclick som skapar en pop-up-notis när man clickar på texten. 

        adapter = new RecyclerViewAdapter(this, mountains, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

Efter det så lägger jag denna kod som länkar veiw med RecyclerView.
    RecyclerView view = findViewById(R.id.recycler_view);

Fösta raden ger den en linearlayout och den andra berättar om den vilken adapter som skall användas. 
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

Jag har även skapat en ny java class som heter RecyclerViewAdapter.
Jag har även skapat en ny java class som heter mountain som håller koll på id, name, cost size med denna kod. notera att endast name kommer användas.

    public class Mountain {

        @SerializedName("ID")
        private String ID;
        @SerializedName("name")
        private String name;
        @SerializedName("cost")
        private int feet;
        @SerializedName("size")
        private int meter;
        
        public String getName() {
            return name;
        }
    }

denna kod skapar en string som hämtar från json filen mountains. 
    private final String JSON_FILE = "mountains.json";
denna kod läser json filen.
    new JsonFile(this, this).execute(JSON_FILE);

Denna kod konverterar json filen så att den kan användas i  RecyclerView.
Gson gson = new Gson();

        // Unmarshall JSON -> list of objects
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type);

sista så skapas en for loop som lägger till mountain name till recyclerView

    for(Mountain mountain : listOfMountains){
    Log.d("json_output_loop", mountain.getName());
    mountains.add(new RecyclerViewItem(mountain.getName()));
    }



## Följande grundsyn gäller dugga-svar:

- Ett kortfattat svar är att föredra. Svar som är längre än en sida text (skärmdumpar och programkod exkluderat) är onödigt långt.
- Svaret skall ha minst en snutt programkod.
- Svaret skall inkludera en kort övergripande förklarande text som redogör för vad respektive snutt programkod gör eller som svarar på annan teorifråga.
- Svaret skall ha minst en skärmdump. Skärmdumpar skall illustrera exekvering av relevant programkod. Eventuell text i skärmdumpar måste vara läsbar.
- I de fall detta efterfrågas, dela upp delar av ditt svar i för- och nackdelar. Dina för- respektive nackdelar skall vara i form av punktlistor med kortare stycken (3-4 meningar).

Programkod ska se ut som exemplet nedan. Koden måste vara korrekt indenterad då den blir lättare att läsa vilket gör det lättare att hitta syntaktiska fel.

```
function errorCallback(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            // Geolocation API stöds inte, gör något
            break;
        case error.POSITION_UNAVAILABLE:
            // Misslyckat positionsanrop, gör något
            break;
        case error.UNKNOWN_ERROR:
            // Okänt fel, gör något
            break;
    }
}
```

Bilder läggs i samma mapp som markdown-filen.

![](screenshot1.png)

Läs gärna:

- Boulos, M.N.K., Warren, J., Gong, J. & Yue, P. (2010) Web GIS in practice VIII: HTML5 and the canvas element for interactive online mapping. International journal of health geographics 9, 14. Shin, Y. &
- Wunsche, B.C. (2013) A smartphone-based golf simulation exercise game for supporting arthritis patients. 2013 28th International Conference of Image and Vision Computing New Zealand (IVCNZ), IEEE, pp. 459–464.
- Wohlin, C., Runeson, P., Höst, M., Ohlsson, M.C., Regnell, B., Wesslén, A. (2012) Experimentation in Software Engineering, Berlin, Heidelberg: Springer Berlin Heidelberg.
