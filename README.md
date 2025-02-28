📌 Configurando a API do TMDB no Projeto

Este guia explica como se cadastrar na API do TMDB, obter sua própria chave de API e configurar o projeto localmente.

🚀 1. Criar Conta e Obter API Key no TMDB

Acesse o site do TMDB: https://www.themoviedb.org

Clique em Sign Up e crie uma conta.

Após o login, vá até Settings (Configurações).

No menu lateral, clique em API e depois em Create API Key.

Escolha Developer e preencha as informações necessárias.

Copie a chave de API gerada, pois será usada no projeto.

🔥 2. Clonar o Repositório

Para obter uma cópia local do projeto, execute o seguinte comando no terminal:

https://github.com/giiomontanari/movie-app-compose.git

🛠 3. Configurar a Chave de API no Projeto

Dentro do diretório do projeto, crie um arquivo chamado apiKey.properties (caso não exista)
na raiz do projeto.

Adicione a seguinte linha ao arquivo:

`API_KEY = "COLOQUE_SUA_API_AQUI"
BASE_URL = "https://api.themoviedb.org/3/"
BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w1280"`

Faça Sync dentro do projeto e vai estar funcionando já.