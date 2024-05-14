# Tabla de contenidos


1. [Introducción](#dao)
2. [Ingeniería de Software](#ingeniería-de-software)
   1. [Diseño UX/UI](#diseño-uxui-del-aplicativo-figma)
   2. [Análisis de necesidades](#análisis-de-necesidades-latex---overleaf)
   3. [Storyboarding](#storyboarding-latex---overleaf)
   4. [Presentación](#presentación-canva)
3. [Instalación de la aplicación](#instalación-de-la-aplicación)
   1. [Linux](#linux)
      1. [Basados en Debian](#debian)
      2. [Fedora](#fedora)
      3. [CentOS o RHEL](#centos-o-rhel)
      4. [Arch](#arch)
   2. [Windows](#windows)
   3. [Mac](#mac)
   4. [Instalación en el dispositvo](#configurar-la-aplicación)
---

# DAO
La app para la elocuencia en chino. Esta aplicación ofrece mediante diferentes modulos una inmersión 
a la cultura China y al aprendizaje del idioma. Utilizamos libros fuentes para la introducción de contenidos y también reforzar el aprendizaje por medio de actividad donde se fomente la *¨cooperación entre usuarios y la interacción de elementos culturales chinos.

---

# Ingeniería de Software

Se hizo un proceso de Ingeniería de Software por medio de analizar requerimientos de usuario, diseños, cómo se desarrolla, entre otros análisis que se realizaron durante los primeros cortes de la asignatura.

---

## Diseño UX/UI del aplicativo (Figma)

Mediante la herramienta Figma, se realizó un diseño interactivo simulado donde se estableció el diseño de la aplicación móvil. Aquí también se definieron los colores y elementos con los que interactuará el usuario. Dentro de la aplicación se recomienda utilizar el modo presentación con el botón *play*. Para acceder a este diseño haga click en el logo del aplicativo Figma a continuación.

<a href='https://shorturl.at/cgoyU'><img src='https://upload.wikimedia.org/wikipedia/commons/3/33/Figma-logo.svg' height="50"></a>

---

## Análisis de necesidades (LaTeX - Overleaf)

En este documento se detallan posibles ideas y las necesidades que presenta el mundo actual de acuerdo al idioma chino y cómo tener la habilidad de este idioma genera un avance tanto intelectual como profesional. El documento fue elaborado en formato *LaTeX* a través de la plataforma *Overleaf*. Para más información acerca del documento y revisar el contenido del mismo, haga *click* en el logo de *Overleaf*. Además de hacer una investigación con estudiantes actuales del idioma chino, esta población que colaboró con el desarrollo de la aplicación se encuentra cursando Chino IV en el Instituto Confucio de la Universidad de Bogotá Jorge Tadeo Lozano, esto es importante porque la población ya ha sido experimentada con el idioma y ha podido saber qué complicaciones tiene con el mismo idioma y cómo se pueden crear herramientas para facilitar este aprendizaje.

<a href='https://www.overleaf.com/read/jkggrzqzkrzp#812582'><img src='https://images.ctfassets.net/nrgyaltdicpt/6gsvc5Ogjmu04I4Miu0uGg/cb1d4391717d2ab8d5e42ede6fb0eef1/overleaf_wide_colour_light_bg.png' height="50"></a>

---

## Storyboarding (LaTeX - Overleaf)

En este *Storyboarding* se hace una recolección de información de las diferentes aplicaciones que existen actualmente y que ayudan al aprendizaje del idioma chino. También se realizaron bocetos acerca de posibles situaciones que presenten personas del común con respecto al aprendizaje del idioma. Para leer el informe completo, haga click en el logo de *Overleaf*.

<a href='https://www.overleaf.com/read/wshxdmdcfspf#e8c83d'><img src='https://images.ctfassets.net/nrgyaltdicpt/6gsvc5Ogjmu04I4Miu0uGg/cb1d4391717d2ab8d5e42ede6fb0eef1/overleaf_wide_colour_light_bg.png' height="50"></a>

---

## Presentación (Canva)

Se introduce todo el tema de la aplicación, la finalidad de esta y porqué es importante en el mundo actual. Esto último es mostrado desde un punto de vista académico y demostrando como el conocimiento es poder. Fue hecho en el programa *Canva*, para acceder al modo lectura de la presentación haga click en el logo de *Figma* presente a continuación.


<a href='https://www.canva.com/design/DAF_yS9chbA/7_VDtAfJWx8XuPMo-PZ4fA/view?utm_content=DAF_yS9chbA&utm_campaign=designshare&utm_medium=link&utm_source=editor'><img src='https://upload.wikimedia.org/wikipedia/commons/0/08/Canva_icon_2021.svg' height="50"></a>

---

# Instalación de la aplicación

Se necesita tener instalado de antes la suite de Android Studio y otras dependencias que se mostrarán a continuación.


## Linux

Se necesita tener preinstalado **git**, dependiendo de su distribución puede que ya lo tenga instalado, si no está seguro ejecute el comando

```bash
git --version
```
Si sale un error entonces debe instalar git, esto dependerá de su distribución, a continuación se muestran algunas

### Debian

```bash
sudo apt update
sudo apt install git 
```

### Fedora
```bash
sudo dnf install git
```

### CentOS o RHEL
```bash
sudo yum install git
```

### Arch
```bash
sudo pacman -S git
```

---

## Windows

Los autores no piensan ayudar a ningún usuario de Windows, suerte con eso.

---

## Mac

Si no ayudamos a los de Windows mucho menos a los de Mac, de hecho, ojalá ni puedas ejecutar la aplicación.

---

## Configurar la aplicación

1. Una vez terminado de instalar **git**, lo siguiente es clonar el repositorio por lo que puede ejecutar el siguiente comando desde una terminal **bash**

```bash
git clone https://github.com/Juanjomarg/Dao.git
```

2. Conectar el dispositivo físico con el computador mediante un USB.

3. En el dispositivo, irse a **configuración**>**Acerca del teléfono**>**Información del software** y dar clic 7 veces en la opción de **Número de construcción**, pedirá la contraseña del dispositivo, una vez digitada ya tendrá habilitado el dispositivo en modo de desarrollador.

<img src="/ImagenesPreview/BuildNumber.png" width="400">

4. Abrir el proyecto en Android Studio y asegurarse de configurar el dispositivo (para más información de cómo configurar un dispositivo para que Android Studio pueda ejecutar una aplicación puede dar clic [aquí](https://developer.android.com/studio/run/device.html)).

5. En Android Studio dar clic en el botón **Run 'app'** o usar el atajo **Shift + F10**.
<img src="/ImagenesPreview/Run app.png" >

6. Felicidades! Ha realizado de manera éxitosa la instalación de la aplicación. Para tener saber más información de los modulos y las secciones de la aplicación, puede leer las secciones a continuación.
---

# Welcome To App
<p align = "center">
<img src="/ImagenesPreview/WelcomeToApp.png" width = "200">
</p>

---
