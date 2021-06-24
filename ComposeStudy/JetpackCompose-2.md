## Jetpack Compose - 2

### Compose의 Layout들

Layout을 들어가기 전에 먼저 Text 3개를 출력하여 보세요

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    Text(text = "I'm Compose")
    Text(text = "Have a good day")
}
```

혹시 위의 코드와 유사하게 코드를 짜셨나요? 위의 코드처럼 짜시면 Text 가 서로 겹쳐진 채로 출력될 것 입니다.
<br>
Compose 에서는 xml에서의 LinearLayout, FrameLayout, ConsttraintLayout과 유사한 함수가 존재 합니다.

```kotlin
@Composable
fun Greeting(name: String) {
    Column { // LinearLayout vertical
        // TODO
    }
    Row { // LinearLayout horizontal
        // TODO
    }
    Box { // FrameLayout
        // TODO
    }
}
```
<br>

![Column_Row_Box](https://user-images.githubusercontent.com/63043772/120327941-498b3c00-c325-11eb-8ae1-b9358a483479.jpg)

<br>

---
[ 2021/06/14 ConstraintLayout 내용 추가 ]

**ConstraintLayout**을 사용하기 위해서는 종속성을 추가하여야 합니다.
```kotlin
implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha06"
```

종속성을 추가하여 준 다음 아래 코드처럼 사용하시면 됩니다.

```kotlin
    ...

    ConstraintLayout { // ConstraintLayout
        // TODO
    }

    ...
```

![jetpack compose - 2 (ConstraintLayout)](https://user-images.githubusercontent.com/63043772/121021039-ec3b3300-c7db-11eb-83e7-7c60bfd76f9f.jpg)

![jetpack compose - 2 (ConstraintLayout - 2)](https://user-images.githubusercontent.com/63043772/121970981-b2a59180-cdb2-11eb-9d30-7f7a7456c2fb.jpg)


<br>

특정 위젯을 식별하기 위해서 createRef() 함수를 사용해 text1, text2, text3을 식별자를 만들어주고 Text에 constrainAs(text1)를 사용하여 Text 위젯을 식별할 수 있게 text1을 연결하여 줍니다.


연결을 한 다음에는 linkTo() 함수를 사용하여 다른 위젯의 위치를 설정해 줄 수 있습니다.

<br>
혹시나 수정 및 보완할 점이 있다면 issue 남겨주세요