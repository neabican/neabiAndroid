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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.ui.campus.CampusVMFactory
import br.edu.ifsc.neabiAndroid.ui.campus.CampusView
import br.edu.ifsc.neabiAndroid.ui.campus.CampusViewModel
import br.edu.ifsc.neabiAndroid.ui.course.CourseView
import br.edu.ifsc.neabiAndroid.ui.course.CourseViewModel
import br.edu.ifsc.neabiAndroid.ui.home.HomeVMFactory
import br.edu.ifsc.neabiAndroid.ui.home.HomeView
import br.edu.ifsc.neabiAndroid.ui.home.HomeViewModel
import br.edu.ifsc.neabiAndroid.ui.theme.NeabiAndroidTheme
import br.edu.ifsc.neabiAndroid.ui.loading.LoadVMFactory
import br.edu.ifsc.neabiAndroid.ui.loading.LoadView
import br.edu.ifsc.neabiAndroid.ui.loading.LoadViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initVM by viewModels<LoadViewModel>(){
            LoadVMFactory(
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
                    NeabicanApp(initVM) {
                        val navController: NavHostController = rememberNavController()
                        val startDestination = "home"

                        NavHost(navController = navController, startDestination = startDestination) {
                            composable("home") {
                                HomeView(
                                    homeViewModel,
                                    navController
                                )
                            }
                            composable("course/{courseId}") { navBackStackEntry ->
                                CourseView(navController, CourseViewModel(Course(1, ".",".")))
                            }
                            composable("campus/{campusId}") { navBackStackEntry ->
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
fun NeabicanApp(loadViewModel: LoadViewModel, content: @Composable() () -> Unit) {
    LoadView(loadViewModel)

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

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