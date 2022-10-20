package br.edu.ifsc.neabiAndroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsc.neabiAndroid.ui.campus.CampusVMFactory
import br.edu.ifsc.neabiAndroid.ui.campus.CampusView
import br.edu.ifsc.neabiAndroid.ui.campus.CampusViewModel
import br.edu.ifsc.neabiAndroid.ui.course.CourseView
import br.edu.ifsc.neabiAndroid.ui.course.CoursesVMFactory
import br.edu.ifsc.neabiAndroid.ui.course.CoursesViewModel
import br.edu.ifsc.neabiAndroid.ui.home.HomeVMFactory
import br.edu.ifsc.neabiAndroid.ui.home.HomeView
import br.edu.ifsc.neabiAndroid.ui.home.HomeViewModel
import br.edu.ifsc.neabiAndroid.ui.navegation.DrawerAppBar
import br.edu.ifsc.neabiAndroid.ui.navegation.DrawerBoby
import br.edu.ifsc.neabiAndroid.ui.navegation.DrawerHeader
import br.edu.ifsc.neabiAndroid.ui.navegation.Items
import br.edu.ifsc.neabiAndroid.ui.splash.SplashScreen
import br.edu.ifsc.neabiAndroid.ui.theme.NeabiAndroidTheme
import br.edu.ifsc.neabiAndroid.ui.splash.SplashVMFactory
import br.edu.ifsc.neabiAndroid.ui.splash.SplashViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel by viewModels<SplashViewModel>(){
            SplashVMFactory(
                (this.applicationContext as NeabiCanApplication).initialRepository
            )
        }

        val homeViewModel by viewModels<HomeViewModel>(){
            HomeVMFactory(
                (this.applicationContext as NeabiCanApplication).homeRepository
            )
        }

        val campusViewModel by viewModels<CampusViewModel>() {
            CampusVMFactory(
                (this.applicationContext as NeabiCanApplication).campusRepository
            )
        }

        val coursesViewModel by viewModels<CoursesViewModel>(){
            CoursesVMFactory(
                (this.applicationContext as NeabiCanApplication).coursesRepository
            )
        }

        setContent {
            NeabiAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NeabicanApp(
                        splashViewModel,
                        homeViewModel,
                        campusViewModel,
                        coursesViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun NeabicanApp(
    viewModel: SplashViewModel,
    homeViewModel: HomeViewModel,
    campusViewModel: CampusViewModel,
    coursesViewModel: CoursesViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val loading = viewModel.isLoading.collectAsState()
    val navController: NavHostController = rememberNavController()

    if(loading.value){
        SplashScreen(viewModel = viewModel)
    }else {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                DrawerAppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            drawerContent = {
                DrawerHeader()
                DrawerBoby(
                    items = Items.menuItems,
                    modifier = Modifier,
                    onItemClick = {
                        when(it.id){
                            "Home" -> {
                                navController.navigate("home")
                            }
                            "Campus" -> {
                                navController.navigate("home")
                            }
                        }
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                )
            }
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeView(
                        homeViewModel,
                        navController
                    )
                }
                composable(
                    route = "course/{courseId}",
                    arguments = listOf(
                        navArgument("courseId"){
                            defaultValue = -1
                            type = NavType.IntType
                        })
                ) {
                    coursesViewModel.setCourse(it.arguments?.getInt("courseId")?:-1)
                    CourseView(coursesViewModel)
                }
                composable(
                    route = "campus/{campusId}",
                    arguments = listOf(
                        navArgument("campusId"){
                            defaultValue = -1
                            type = NavType.IntType
                        })
                ){
                    campusViewModel.setCampus(it.arguments?.getInt("campusId")?:-1)
                    CampusView(navController, campusViewModel)
                }
            }

        }
    }
}