# Aquilombar - Aplicativo Neabi

## Descrição

**Aquilombar** é um aplicativo mobile desenvolvido utilizando Kotlin, destinado a fornecer informações sobre faculdades públicas, cursos oferecidos, assistência estudantil e muito mais, no contexto do projeto Neabi. O aplicativo consome uma API desenvolvida em Django para obter os dados necessários e utiliza várias tecnologias modernas para criar uma experiência de usuário fluida e eficiente.

> **Status da Aplicação:** O aplicativo encontra-se **temporariamente indisponível na Google Play Store** em razão do término da vigência da hospedagem do *web service* que provê a API de dados. A distribuição e o funcionamento completo do app serão restabelecidos mediante a renovação do fomento do projeto de extensão para contratação de nova infraestrutura de servidores.

## Tecnologias Utilizadas

- **Linguagem:** Kotlin (2.4.x)
- **Ambiente:** Java JVM 21
- **Interface:** Jetpack Compose (com Material Design 2 e Compose BOM)
- **Arquitetura:** MVVM (Model-View-ViewModel)
- **Injeção de Dependência:** Dagger Hilt
- **Rede:** Retrofit & Moshi (JSON Serialization)
- **Persistência de Dados:** Room Database
- **Carregamento de Imagens:** Coil
- **Navegação:** Jetpack Navigation Compose
- **Serviços de Mapa:** Google Maps Compose & Google Play Services Maps
- **Recursos de Hardware:** Localização (Fused Location Provider) e Accompanist Permissions
- **Processamento de Anotações:** KSP (Kotlin Symbol Processing)

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

## Autores e Equipe do Projeto

### Coordenação e Gestão
- **Cícero Santiago de Oliveira** — Coordenador Geral do Projeto
- **Alessandro Eleutério de Oliveira** — Coordenador Adjunto
- **Reneu Cesar Ziger** — Responsável Financeiro

### Orientação e Liderança Técnica
- **Maurício Begnini** — Orientador / Líder de Desenvolvimento Android
- **Alexandre Augusto Alberto Moreira de Abreu** — Orientador / Líder de Desenvolvimento Web

### Equipe de Desenvolvimento (Discentes Bolsistas)
- **Bruno Perdona** — Desenvolvedor Android e Web
- **Eduardo Henrique de Oliveira** — Desenvolvedor Web 
- **Emanuel Jesus Santos** — Desenvolvedor Android e Web
- **Gustavo Ziger** — Desenvolvedor Android e Web
