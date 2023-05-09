package com.example.a30daysfilms.data

import com.example.a30daysfilms.R

object FilmsRepository {
    val films = listOf(
        Film(
            title = "Bigger",
            image = R.drawable.bigger,
            description = "La historia de los hermanos Joe y Ben Weider, quienes superaron el antisemitismo, los prejuicios sociales y la pobreza para fundar algo más que un negocio, una disciplina: el fisiculturismo moderno. Ellos descubrieron a Arnold Schwarzenegger.",
            releaseDate = "12 de octubre de 2018",
            language = "English",
            director = "George Gallo",
        ),
        Film(
            title = "The Great Hack",
            image = R.drawable.the_great_hack,
            description = "La consultora británica Cambridge Analytica simboliza el lado oscuro de las redes sociales después de las elecciones presidenciales de 2016 en los Estados Unidos.",
            releaseDate = "26 de enero de 2019",
            language = "English",
            director = "Karim Amer, Jehane Noujaim"
        ),
        Film(
            title = "The Social Network",
            image = R.drawable.the_social_network,
            description = "Mark Zuckerberg, un estudiante de Harvard, crea la red social que terminará convirtiéndose en Facebook, pero recibe acusaciones del cofundador y de dos hermanos que sostienen que la idea fue suya.",
            releaseDate = "1 de octubre de 2010",
            language = "English",
            director = "David Fincher"
        ),
        Film(
            title = "Get Hard",
            image = R.drawable.get_hard,
            description = "Un banquero inversionista que será encarcelado le pide al hombre que lava su carro que lo prepare para su vida detrás de las rejas.",
            releaseDate = "27 de marzo de 2015",
            language = "English",
            director = "Etan Cohen"
        ),
        Film(
            title = "Bohemian Rhapsody",
            image = R.drawable.bohemian_rhapsody,
            description = "Freddie Mercury desafía los estereotipos y se convierte en uno de los vocalistas más reconocidos de la música mundial. Después de dejar la banda Queen para seguir una carrera como solista, Mercury se reúne con la banda para dar una de las mejores actuaciones en la historia del rock 'n' roll.",
            releaseDate = "24 de octubre de 2018 ",
            language = "Englis",
            director = "Bryan Singer, Dexter Fletcher"
        ),
         Film(
             title = "Closer",
             image = R.drawable.closer,
             description = "Una escritora, una fotógrafa, una joven mujer y una exitosa dermatóloga tienen que hacerle frente al amor y la traición.",
             releaseDate = "3 de diciembre de 2004",
             language = "English",
             director = "Mike Nichols"
         ),
         Film(
             title = "Toc Toc",
             image = R.drawable.toc_toc,
             description = "Un grupo de pacientes coinciden a la misma hora en la consulta de un importante psicólogo. Todos ellos padecen Trastorno Obsesivo Compulsivo.",
             releaseDate = "6 de octubre de 2017",
             language = "Español",
             director = "Vicente Villanueva"
         ),
         Film(
             title = "Promoción Fantasma",
             image = R.drawable.promocion_fantasma,
             description = "Un maestro con poderes paranormales ayuda a graduarse a un grupo de espíritus adolescentes",
             releaseDate = "3 de febrero de 2012",
             language = "Español",
             director = "Javier Ruiz Caldera",
             collection ="2,6 millones USD"
         ),
         Film(
             title = "La Tribu",
             image = R.drawable.la_tribu,
             description = "Fidel, un despiadado director de Recursos Humanos, lo pierde todo tras un episodio sexual. Fidel intenta recuperar su vida y decide conocer a su madre biológica. Tras un desastroso encuentro, tiene un accidente y pierde la memoria.",
             releaseDate = "16 de marzo de 2018",
             language = "Español",
             director = "Fernando Colomo"
         ),
         Film(
             title = "Loco por ella",
             image = R.drawable.loco_por_ella,
             description = "Tras pasar una fabulosa noche juntos, Adri descubre que solo hay una manera de ver a Carla: deberá ingresar en el centro psiquiátrico en el que ella está internada.",
             releaseDate = "26 de febrero de 2021",
             language = "Español",
             director = "Dani de la Orden"
         ),
         Film(
             title = "Tod@s Caen",
             image = R.drawable.todas_caen,
             description = "Adán es un seductor impenitente y Mia una mujer ambiciosa y feminista. Ambos tratan de seducir al otro para obtener lo que ansían, pero los dos saben que en este juego todo vale, excepto enamorarse.",
             releaseDate = "20 de septiembre de 2019",
             language = "Español",
             director = "Ariel Winograd",
             collection = "9,667 millones USD"
         ),
         Film(
             title = "3 Idiotas",
             image = R.drawable.tres_idiotas,
             description = "Unos amigos se embarcan en una aventura para encontrar a un compañero de la universidad que desapareció el día de la graduación.",
             releaseDate = "31 de marzo de 2017",
             language = "Español",
             director = "Carlos Bolado",
             collection = "7,9 millones USD"
         ),
         Film(
             title = "A Nice Girl Like You",
             image = R.drawable.a_nice_girl_like_you,
             description = "Después de ser acusada de ser demasiado inhibida por su exnovio, una violinista crea una lista de tareas bastante salvaje que la envía a un viaje vertiginoso de autodescubrimiento.",
             releaseDate = "17 de julio de 2020",
             language = "English",
             director = "Nick Riedell, Chris Riedell"
         ),
         Film(
             title = "Ahora o nunca",
             image = R.drawable.ahora_o_nunca,
             description = "Eva y Álex deciden casarse en el pequeño pueblo de la campiña inglesa donde se conocieron. Sin embargo, se les presenta un problema inesperado: una huelga de controladores impide que Alex y sus invitados lleguen hasta donde está Eva.",
             releaseDate = " 19 de junio de 2015",
             language = "Español",
             director = "Maria Ripoll"
         ),
         Film(
             title = "Alvin and The Chipmunks The Road Chip",
             image = R.drawable.alvin_and_the_chipmunks_the_road_chip,
             description = "A raíz de una serie de malos entendidos, Alvin, Simón y Teodoro llegan a creer que Dave le va a proponer matrimonio a su nueva novia en Miami y los va a abandonar. Los tres se embarcan en un viaje para evitar que esto suceda.",
             releaseDate = "18 de diciembre de 2015",
             language = "English",
             director = "Walt Becker",
             collection = "234,8 millones USD"
         ),
         Film(
             title = "Hasta Que La Boda Nos Separe",
             image = R.drawable.hasta_que_la_boda_nos_separe,
             description = "Marina es una joven que se gana la vida organizando bodas. A diferencia de sus clientes, ella disfruta de una vida sin ataduras ni compromisos, hasta que una noche conoce a Carlos. Pero él tiene novia: Alexia, una amiga de la infancia de Marina.",
             releaseDate = "14 de febrero de 2020",
             language = "Español",
             director = "Dani de la Orden"
         ),
         Film(
             title = "Minions",
             image = R.drawable.minions,
             description = "Los minions, ingenuos y torpes, buscan un verdadero villano al que servir. A lo largo de una evolución de millones de años, los minions se han puesto al servicio de los amos más despreciables. Kevin, acompañado por el rebelde Stuart y el adorable Bob, emprende un emocionante viaje para conseguir una jefa a quien servir, la terrible Scarlet Overkill.",
             releaseDate = "10 de julio de 2015",
             language = "English",
             director = "Pierre Coffin, Kyle Balda",
             collection = "1,159 miles de millones USD"
         ),
         Film(
             title = "Ocho Apellidos Catalanes",
             image = R.drawable.ocho_apellidos_catalanes,
             description = "En la secuela de \"Ocho apellidos vascos\", Amaia se ha separado de Rafa y se ha enamorado de un catalán; las alarmas de Koldo se encienden al enterarse de esto dado que ya se había hecho la idea de que su hija saliera con un andaluz.",
             releaseDate = "20 de noviembre de 2015",
             language = "Español",
             director = "Emilio Martínez-Lázaro",
             collection = "36,1 millones EUR"
         ),
         Film(
             title = "Perdiendo El Este",
             image = R.drawable.perdiendo_el_este,
             description = "Tras su poco productiva aventura laboral en Berlín, Braulio pasa un año en China intentando entrar como investigador a la Universidad de Hong Kong. Cuando está a punto de lograrlo con una perfecta presentación, una vez más, se equivoca.",
             releaseDate = "15 de febrero de 2019",
             language = "Español",
             director = "Paco Caballero"
         ),
         Film(
             title = "Star Wars Episode III Revenge of the Sith",
             image = R.drawable.star_wars_episode_tres,
             description = "Seducido por el lado oscuro, Anakin Skywalker se rebela contra su mentor, Obi-Wan Kenobi, y se convierte en Darth Vader.",
             releaseDate = "19 de mayo de 2005",
             language = "English",
             director = "George Lucas"
         ),
         Film(
             title = "Sing",
             image = R.drawable.sing,
             description = "Un cerdo, un ratón, un puerco espín, un gorila, un elefante y otros animales se reúnen en un teatro koala para una competencia de canto.",
             releaseDate = "21 de diciembre de 2016",
             language = "English",
             director = "Garth Jennings"
         ),
         Film(
             title = "Sing 2",
             image = R.drawable.sing2,
             description = "Buster Moon y su elenco de animales artistas se preparan para lanzar un deslumbrante espectáculo escénico en la capital mundial del entretenimiento. Solo hay un problema: debe convencer a la estrella de rock más solitaria del mundo de unirse a ellos.",
             releaseDate = "22 de diciembre de 2021",
             language = "English",
             director = "Garth Jennings"
         ),
         Film(
             title = "Odio, de Dani Rovira",
             image = R.drawable.odio_de_dani_rovira,
             description = "Desde su tierra natal, Málaga, Dani Rovira reflexiona sobre el odio absurdo del ser humano en este graciosísimo especial de comedia sin tapujos.",
             releaseDate = "22 de febrero de 2021",
             language = "Español",
             director = "Mario Briongos"
         ),
         Film(
             title = "Harry Potter And The Sorcerer's Stone",
             image = R.drawable.harry_potter_and_the_sorcerers_stone,
             description = "El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Debe asistir a una famosa escuela de magia y hechicería, donde entabla una amistad con dos jóvenes que se convertirán en sus compañeros de aventura.",
             releaseDate = "16 de noviembre de 2001",
             language = "English",
             director = "Chris Columbus"
         ),
         Film(
             title = "Harry Potter And The Secret Chamber",
             image = R.drawable.harry_potter_and_the_secret_chamber,
             description = "Terminado el verano, Harry no ve la hora de abandonar la casa de sus odiosos tíos. Inesperadamente se presenta en su dormitorio Dobby, un elfo doméstico, que le anuncia que correrá un gran peligro si vuelve a Hogwarts.",
             releaseDate = "15 de noviembre de 2002",
             language = "English",
             director = "Chris Columbus"
         ),
         Film(
             title = "Harry Potter And The Prisoner Of Azkaban",
             image = R.drawable.harry_potter_prisoner_azkaban,
             description = "El tercer año de estudios de Harry en Hogwarts se ve amenazado por la fuga de Sirius Black de la prisión de Azkaban. Al parecer, se trata de un peligroso mago que fue cómplice de Lord Voldemort y que intentará vengarse de Harry Potter.",
             releaseDate = "4 de junio de 2004",
             language = "English",
             director = "Alfonso Cuarón"
         ),
         Film(
             title = "Harry Potter And The Goblet Of Fire",
             image = R.drawable.harry_potter_and_the_goblet_of_fire,
             description = "Hogwarts se prepara para el Torneo de los Tres Magos, en el que competirán tres escuelas de hechicería. Para sorpresa de todos, Harry Potter es elegido para participar en la competencia, en la que deberá luchar contra dragones, internarse en el agua y enfrentarse a sus mayores miedos.",
             releaseDate = "18 de noviembre de 2005",
             language = "English",
             director = "Mike Newell"
         ),
         Film(
             title = "Harry Potter And The Order Of The Phoenix",
             image = R.drawable.harry_potter_and_the_order_of_the_phoenix,
             description = "En su quinto año en Hogwarts, Harry descubre que muchos integrantes de la comunidad de magos no conocen la verdad acerca de su encuentro con Lord Voldemort. Cornelius Fudge, ministro de magia, designa a Dolores Umbridge como maestra de defensa contra de las artes oscuras",
             releaseDate = "11 de julio de 2007",
             language = "English",
             director = "David Yates"
         ),
         Film(
             title = "Harry Potter And The Half Blood Prince",
             image = R.drawable.harry_potter_and_the_half_blood_prince,
             description = "Harry descubre un poderoso libro y, mientras trata de descubrir sus orígenes, colabora con Dumbledore en la búsqueda de una serie de objetos mágicos que ayudarán en la destrucción de Lord Voldemort.",
             releaseDate = "15 de julio de 2009",
             language = "English",
             director = "David Yates"
         )

    )
}


