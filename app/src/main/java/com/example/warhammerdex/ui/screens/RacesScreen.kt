package com.example.warhammerdex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.warhammerdex.LordTemp
import com.example.warhammerdex.R
import com.example.warhammerdex.data.FactionTemp
import com.example.warhammerdex.data.RaceTemp

val factionList = listOf(
    FactionTemp(
        id = 0,
        name = "Las Provincias Septentrionales",
        race = 0,
        logoId = R.drawable.las_provincias_septentrionales,
        lordTemp = LordTemp(
            name = "Miao Ying",
            faction = 0,
            imageId = R.drawable.miao_ying
        )
    ),
    FactionTemp(
        id = 0,
        name = "Las Provincias Septentrionales",
        race = 0,
        logoId = R.drawable.las_provincias_septentrionales,
        lordTemp = LordTemp(
            name = "Miao Ying",
            faction = 0,
            imageId = R.drawable.miao_ying
        )
    ),
    FactionTemp(
        id = 0,
        name = "Las Provincias Septentrionales",
        race = 0,
        logoId = R.drawable.las_provincias_septentrionales,
        lordTemp = LordTemp(
            name = "Miao Ying",
            faction = 0,
            imageId = R.drawable.miao_ying
        )
    ),
)

val raceList = listOf(
    RaceTemp(
        id = 0,
        name = "Gran Catai",
        logoId = R.drawable.gran_catai,
        description = "Catai es el imperio más grande en el mundo de Warhammer, constituido en su mayoría por humanos, y gobernado por dragones inmortales que pueden adoptar forma humana. Esta raza se inspira en gran medida en la historia de la China Imperial, así como en la mitología china. Son firmes oponentes del caos, pero su posición en el lejano oriente los tiene aislados. Miles de millas de cualquier aliado potencial, los catayanos han construido el Gran Bastión en su frontera septentrional para mantener a raya a las fuerzas enemigas."
    )
)

fun getRaceFactions(race: Int): List<FactionTemp> {
    return factionList.filter { it.race == race}
}
@Composable
fun RacesScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    RaceList(
        modifier = modifier
            .fillMaxSize(),
        navHostController = navHostController
    )
}

fun navigateToRace(navHostController: NavHostController, race: Int) {

}

@Composable
fun ItemsList(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    content: @Composable () -> Unit,
    items: List<Unit>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items) {
            content()
        }
    }
}

@Composable
fun RaceList(modifier: Modifier = Modifier, navHostController: NavHostController = rememberNavController()) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(raceList) {
            RaceCard(
                name = it.name,
                imageResource = it.logoId,
                race = it.id,
                onClick = { navigateToRace(navHostController, it.id) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
        }
    }
}

@Composable
fun RaceCard(
    name: String,
    imageResource: Int,
    race: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val painter = painterResource(id = imageResource)
    Card(
        onClick = onClick,
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 200f
                        )
                    )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Text(
                            text = name,
                            color = Color.White,
                            fontSize = 42.sp,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                    FactionRow(
                        race = race,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun FactionRow(modifier: Modifier = Modifier, race: Int) {
    val factions = getRaceFactions(race)
    Row(
        modifier = modifier
    ) {
       factions.forEach{
           val painter = painterResource(id = it.logoId)
           Image(
               modifier = Modifier
                   .padding(end = 4.dp),
               painter = painter,
               contentDescription = null
           )
       }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RaceList()
}