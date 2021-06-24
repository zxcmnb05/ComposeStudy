## Jetpack Compose - 1

**Jetpack Compose**는 기존 안드로이드 코드에서 사용하는 xml 레이아웃을 사용하지 않고 선언형 함수를 사용하여 코드를 간소화할 수 있습니다. 

먼저 Jetpack Compose를 사용하기 위해서는 아래 링크로 이동하여 설정하여야 합니다.

개발 환경 설정: <a href="https://developer.android.com/jetpack/compose/setup">Compose</a>

### 설정이 끝나셨다면 Compose를 시작해봅시다.

먼저 아래 코드를 봐주세요

아래 코드를 작성을 하면 Hello world 가 출력이 됩니다.

```kotlin
class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world!")
        }
    }
}
```
기존에 xml 레이아웃을 사용하였을 때에 비하면 아주 간단하게 한 줄로 Text를 출력할 수 있게 됩니다.

위의 코드를 함수화 시킬 수 있는데 그 방법은
함수 앞에 @Composable 주석을 추가하여 함수처럼 사용할 수 있습니다.

```kotlin
class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Compose")
        }
    }
}

@Composable
fun Greeting(name: String){
    Text("Hello $name")
}
```

그리고 Compose에서는 미리 보기 기능을 지원하는데
이 기능을 사용하기 위해서는 함수 앞에 @Preview 주석을 사용하면 미리 보기 기능을 사용할 수 있습니다.

하지만 만약 함수에서 매개변수를 받아 온다면 Preview 기능을 가진 함수를 만들어서 미리 보기 기능을 사용할 함수를 호출해 주면 됩니다.

``` kotlin
@Composable
fun Greeting(name: String){
    Text("Hello $name")
}

@Preview
@Composable
fun DefaultPreview() {
    Greeting("Android")
}
```

![preview](https://user-images.githubusercontent.com/63043772/120181875-9f3de680-c248-11eb-99d3-78f505981490.png)

- @Preview를 사용하여 미리 보기 기능을 사용하였을 때 위의 사진의 오른쪽과 같이 미리 보기가 뜨는 것을 볼 수 있습니다.

다만 주의할 점은 @Preview 주석을 단 함수에서 값을 불러 오기 때문에 실제 앱을 빌드를 하였을 때는 @Preview가 보이지 않고 setContent에서 불러오는 함수가 출력됩니다.
<br>


혹시나 수정 및 보완할 점이 있다면 issues 남겨주세요
