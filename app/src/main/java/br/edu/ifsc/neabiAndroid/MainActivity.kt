package br.edu.ifsc.neabiAndroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.ui.campus.CampusVMFactory
import br.edu.ifsc.neabiAndroid.ui.campus.CampusView
import br.edu.ifsc.neabiAndroid.ui.campus.CampusViewModel
import br.edu.ifsc.neabiAndroid.ui.course.CourseView
import br.edu.ifsc.neabiAndroid.ui.course.CourseViewModel
import br.edu.ifsc.neabiAndroid.ui.home.HomeVMFactory
import br.edu.ifsc.neabiAndroid.ui.home.HomeView
import br.edu.ifsc.neabiAndroid.ui.home.HomeViewModel
import br.edu.ifsc.neabiAndroid.ui.splash.SplashScreen
import br.edu.ifsc.neabiAndroid.ui.theme.NeabiAndroidTheme
import br.edu.ifsc.neabiAndroid.ui.splash.SplashVMFactory
import br.edu.ifsc.neabiAndroid.ui.splash.SplashViewModel
import kotlinx.coroutines.delay
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
        setContent {
            NeabiAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NeabicanApp(splashViewModel) {
                        val navController: NavHostController = rememberNavController()
                        val startDestination = "home"

                        NavHost(navController = navController, startDestination = startDestination) {
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
                                CourseView(navController, CourseViewModel(Course(it.arguments?.getInt("campusId")?:-1,"teste","teste")))
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
        }
    }
}

@Composable
fun NeabicanApp(viewModel: SplashViewModel,content: @Composable() () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val loaded = viewModel.isLoading.collectAsState()

    if(loaded.value){
        SplashScreen(viewModel = viewModel)
    }else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Sistema Educacional") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {}
        ) {
            content()
        }
    }
}