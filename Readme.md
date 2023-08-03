# Aquilombar - Aplicativo Neabi

## Descrição

**Aquilombar** é um aplicativo mobile desenvolvido utilizando Kotlin, destinado a fornecer informações sobre faculdades públicas, cursos oferecidos, assistência estudantil e muito mais, no contexto do projeto Neabi. O aplicativo consome uma API desenvolvida em Django para obter os dados necessários e utiliza várias tecnologias modernas para criar uma experiência de usuário fluida e eficiente.

## Tecnologias Utilizadas

- Linguagem: Kotlin
- Java: SDK/JVM em Java 11
- Frameworks: Jetpack Compose, Retrofit, Moshi, LiveData, Coil, Room, ViewModel, Navigation, Dagger Hilt
- Recursos: Google Maps, Localização (Google Geocoding API)

## Recursos Principais

- Exibição de uma lista de faculdades públicas
- Detalhes dos cursos oferecidos por cada faculdade
- Informações sobre assistência estudantil
- Integração com Google Maps para visualizar a localização das faculdades usando a API de geocodificação do Google

## Instalação

1. Clone este repositório para o seu ambiente local.
2. Abra o projeto no Android Studio.
3. Certifique-se de ter as versões corretas do Kotlin configuradas.
4. No arquivo `app/src/main/AndroidManifest.xml`, na linha 27, dentro de `<meta-data>`, adicione a chave de API da Google Geocoding API no atributo `android:value`.

   Exemplo:
   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="SUA_CHAVE_DE_API_AQUI" />