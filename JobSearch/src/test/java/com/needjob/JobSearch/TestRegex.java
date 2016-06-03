package com.needjob.JobSearch;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    @Test
    public void testMatchMultiLines() {
        String data = "Pourquoi vous quittez votre société actuelle ? Que cherchez-vous ? \n" +
                " Dernier entretien annuel décevant = pas d'augmentation \n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Quelle expérience est la plus/moins enrichissante ? \n" +
                " LE BON COIN \n" +
                "Conception de cubes\n" +
                "Problématique de volumétrie\n" +
                "\n" +
                "  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez-vous m'expliquez l'organisation des projets dans l'expérience la plus significative, du recueil du besoin jusqu'à la livraison en production ?\" \n" +
                "le candidat doit présenter les différentes phases et activités spécifiques à l'entreprise dans laquelle il est intervenu travail sur plusieurs projet en meme tps\n" +
                "extaction des infos\n" +
                "les charger\n" +
                "conception de nouveaux cubes et modification des cubes existants\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Maîtrisez-vous un outil décisionnel? Le(s)quel(s) ? \n" +
                "Et combien d'années au cumul? Pentaho 3 ans\n" +
                "Talend 1 an\n" +
                "SQL 3ans  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me donner une definition d’indicateur de pilotage? \n" +
                "\"c'est une information, dont la consultation amène à un savoir important sur la direction prise par une entreprise\". La consultation d'un indicateur de pilotage doit permettre de prendre des décisions : augmenter/diminuer les investissements, améliorer la qualité... En anglais, on parle de KPI : Key Performance Indicator indicateur qui fourni des infos détaillé de l’activité et qui permet au décideur de prendre des décisions  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous déjà participé à la conception d’un entrepôt de données ou datawarehouse ? Cbien de temps ? \n" +
                "cf. schéma de la chaîne décisionnelle. L'entrepôt de données est une base de données où l'on récupère, théoriquement, toutes les données de l'entreprise pour des besoins en reporting. En anglais : Datawarehouse (DWH). Il existe également le terme Datamart (magasin de données, DMT). C'est une base de données décisionnelle ciblée sur une partie précise du métier de l'entreprise (ex : indicateurs RH). En clair, un DWH ou un DMT contient des indicateurs. Ces indicateurs sont organisées d'une manière particulière, cf VIP Day du 18/4/2014. oui 3 ans \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous déjà participé à la conception d’un Univers (comme on l'appelle dans Business Objects) ? Cbien de temps? \n" +
                "L'univers se place au-dessus du DWH, il permet de lister et d'accéder aux indicateurs depuis une solution de reporting. Ex : si dans ton DWH tu as l'indicateur dont le nom technique est IND-CA-41, dans ton univers, tu pourras faire correspondre ce nom technique avec le nom d'indicateur, plus facilement compréhensible par l'utilisateur, suivant : \"Chiffre d'affaire par activités de conseil\". L'utilisateur, au moment de créer son rapport, a ainsi toutes les infos sur les indicateurs disponibles. On dit que dans un univers, on crée des informations qui ont du sens pour l'analyse de l'utilisateur (couche sémantique). On parle aussi de Metadata  business table : langage Pentaho\n" +
                "création de domaine couche... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous déjà participé à la conception d’un cube ? Cbien de temps ? \n" +
                "Un cube de données (multidimensionnel) est une autre forme de représentation et stockage des données. Ce n'est pas comme une base de données, mais ça peut s'appuyer sur une base de données sous-jacente. Il y a des avantages à stocker les données dans un cube : rapidité d'accès, possibilité de modification des indicateurs... Le choix d'un cube ou une base dépend du contexte et du besoin des utilisateurs. oui 2 ans \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Création de rapports d'analyse ? Cbien de temps ? \n" +
                "Les rapports sont créés à partir d'univers/metadata et sont ensuite analysés par les utilisateurs. Généralement, les utilisateurs ont accès au système qui permet de créer ses propres rapports d'analyse (ex : Business Objects Web Intelligence). Pour les rapports complexes, ce sont les informaticiens (MOE ou MOA) qui s'en occupent. oui \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me donner une definition de Recette ?  \n" +
                "(importance, stratégie) vérifier si le fonctionnement prévu par le cahier charge est fonctionnel \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous réalisé une Formation Utilisateur ? \n" +
                " oui \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Comment voyez-vous votre évolution dans les 5 prochaines années ? \n" +
                " chef de projet \n" +
                "Pourquoi pas de la big data... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Qu’attendez-vous de votre société de conseil ? \n" +
                "(animation, management) missions intéressantes\n" +
                "\n" +
                "mission longue duree \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Vos principales qualités ? Defauts ? \n" +
                "Dans quelles circonstances avez-vous fait preuve des qualités que vous dites posséder ? honnêteté parfois manque de filtre \n" +
                "\n" +
                "j'aime le travail bien fait \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Etes vous capable de vous adapter rapidement? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction ? Oui bcp de mission courtes contexte différents... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Comment vous comportez-vous face au stress/aux échecs? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction ? Les échecs me font avancer... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Dit-on de vous que vous etes organisé ? \n" +
                "Quelles difficultés importantes avez-vous rencontrées dans votre dernier poste ? Comment les avez-vous surmontés ?  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Donnez une note sur 20 à votre motivation ?  \n" +
                "Expliquez l’ecart avec 20? 20/20 \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "De quoi êtes-vous le plus fier dans votre carrière ? \n" +
                "Formation, projet expertise outils open source \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me preciser ce que vous avez compris de notre société ? \n" +
                " bi\n" +
                "package \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Votre mobilité ?  \n" +
                "(Banlieue, Province, Région, Pays, Internationale)   \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Quelle est votre remuneration aujourd'hui? ou dernier poste? \n" +
                "Partie variable, fixe et avantages...  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Vos prétentions salariales ?  \n" +
                "  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Quelle est votre disponibilité ? Etes-vous en processus de recrutement dans un autre cabinet ? \n" +
                " 3 mois negociable \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Personnes à contacter pour une prise de référence?  *\n" +
                " Ne souhaite pas communiquer de contact \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous des questions ? Voulez-vous revenir sur un point que nous n'aurions pas abordé ? \n" +
                " PROCESS \n" +
                "--";

//        data = data
//                .replaceAll("[(]"," ")
//                .replaceAll("[)]" ," ")
//                .replaceAll("[/]", " ")
//                .replaceAll("[?]", " ") ;

//       data =  data.replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\");
       // System.out.println(data);
        
        String data1 = "Pourquoi vous quittez votre société actuelle ? Que cherchez-vous ?" ; 
        data1 = data1.replaceAll("[?]", "\\\\\\?") ; 
        System.out.println(data1);

        Matcher regexMatcher;
        String ResultString = "no  match";
        Pattern regex1 = Pattern.compile("Que cherchez-vous(.*)Quelle expérience est la plus moins enrichissante   ", Pattern.DOTALL);
        regexMatcher = regex1.matcher(data);
        if (regexMatcher.find()) {
            ResultString = regexMatcher.group(1);
        }

        System.out.println(ResultString);

        Pattern regex2 = Pattern.compile("Quelle expérience est la plus\\/moins enrichissante \\?(.*)Pouvez-vous m'expliquez l'organisation des projets dans l'expérience la plus significative, du recueil du besoin jusqu'à la livraison en production \\?", Pattern.DOTALL);
        regexMatcher = regex2.matcher(data);
        if (regexMatcher.find()) {
            ResultString = regexMatcher.group(1);
        }
        System.out.println(ResultString);
        String res = null;
        Pattern regex3 = Pattern.compile("Pouvez-vous m'expliquez l'organisation des projets dans l'expérience la plus significative, du recueil du besoin jusqu'à la livraison en production \\?\" \n" +
                "le candidat doit présenter les différentes phases et activités spécifiques à l'entreprise dans laquelle il est intervenu travail sur plusieurs projet en meme tps(.*)Maîtrisez-vous un outil décisionnel\\? Le\\(s\\)quel\\(s\\) \\?", Pattern.DOTALL);
        regexMatcher = regex3.matcher(data);
        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }
        System.out.println(res);

        res = "no match !!";
        Pattern regex4 = Pattern.compile("Maîtrisez-vous un outil décisionnel\\? Le\\(s\\)quel\\(s\\) \\? \n" +
                "Et combien d'années au cumul\\? (.*)Pouvez vous me donner une definition d’indicateur de pilotage?", Pattern.DOTALL);
        regexMatcher = regex4.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex5 = Pattern.compile("Pouvez vous me donner une definition d’indicateur de pilotage\\?(.*)\n" +
                "Avez-vous déjà participé à la conception d’un entrepôt de données ou datawarehouse \\? Cbien de temps \\? ", Pattern.DOTALL);
        regexMatcher = regex5.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }
        System.out.println(res);
        res = "no match !!";
        Pattern regex6 = Pattern.compile("Avez-vous déjà participé à la conception d’un entrepôt de données ou datawarehouse \\? Cbien de temps \\?(.*)Avez-vous déjà participé à la conception d’un Univers \\(comme on l'appelle dans Business Objects\\) \\? Cbien de temps\\? ", Pattern.DOTALL);
        regexMatcher = regex6.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex7 = Pattern.compile("Avez-vous déjà participé à la conception d’un Univers \\(comme on l'appelle dans Business Objects\\) \\? Cbien de temps\\? (.*)Avez-vous déjà participé à la conception d’un cube \\? Cbien de temps \\?", Pattern.DOTALL);
        regexMatcher = regex7.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex8 = Pattern.compile("Avez-vous déjà participé à la conception d’un cube \\? Cbien de temps \\?(.*)Création de rapports d'analyse \\? Cbien de temps \\?", Pattern.DOTALL);
        regexMatcher = regex8.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex9 = Pattern.compile("Création de rapports d'analyse \\? Cbien de temps \\?(.*)Pouvez vous me donner une definition de Recette \\?", Pattern.DOTALL);
        regexMatcher = regex9.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex10 = Pattern.compile("Pouvez vous me donner une definition de Recette \\?(.*)Avez-vous réalisé une Formation Utilisateur \\?", Pattern.DOTALL);
        regexMatcher = regex10.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex11 = Pattern.compile("Avez-vous réalisé une Formation Utilisateur \\?(.*)Comment voyez-vous votre évolution dans les 5 prochaines années \\?", Pattern.DOTALL);
        regexMatcher = regex11.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex12 = Pattern.compile("Comment voyez-vous votre évolution dans les 5 prochaines années \\?(.*)Qu’attendez-vous de votre société de conseil \\?", Pattern.DOTALL);
        regexMatcher = regex12.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex13 = Pattern.compile("Qu’attendez-vous de votre société de conseil \\?(.*)Vos principales qualités \\? Defauts \\?", Pattern.DOTALL);
        regexMatcher = regex13.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);
        res = "no match !!";
        Pattern regex14 = Pattern.compile("Vos principales qualités \\? Defauts \\?(.*)Etes vous capable de vous adapter rapidement\\?", Pattern.DOTALL);
        regexMatcher = regex14.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex15 = Pattern.compile("Vos principales qualités \\? Defauts \\? \n" +
                "Dans quelles circonstances avez-vous fait preuve des qualités que vous dites posséder \\? honnêteté parfois manque de filtre(.*)\n" +
                "Etes vous capable de vous adapter rapidement\\? ", Pattern.DOTALL);
        regexMatcher = regex15.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex16 = Pattern.compile("Etes vous capable de vous adapter rapidement\\? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction \\?(.*)Comment vous comportez-vous face au stress\\/aux échecs\\?", Pattern.DOTALL);
        regexMatcher = regex16.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);
        res = "no match !!";
        Pattern regex17 = Pattern.compile("Comment vous comportez-vous face au stress\\/aux échecs\\? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction \\?(.*)Dit-on de vous que vous etes organisé \\?", Pattern.DOTALL);
        regexMatcher = regex17.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex18 = Pattern.compile("Dit-on de vous que vous etes organisé \\?(.*)Donnez une note sur 20 à votre motivation \\?", Pattern.DOTALL);
        regexMatcher = regex18.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex19 = Pattern.compile("Donnez une note sur 20 à votre motivation \\?  \n" +
                "Expliquez l’ecart avec 20\\?(.*)De quoi êtes-vous le plus fier dans votre carrière \\?", Pattern.DOTALL);
        regexMatcher = regex19.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex20 = Pattern.compile("De quoi êtes-vous le plus fier dans votre carrière \\?(.*)Pouvez vous me preciser ce que vous avez compris de notre société \\?", Pattern.DOTALL);
        regexMatcher = regex20.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex21 = Pattern.compile("Pouvez vous me preciser ce que vous avez compris de notre société \\?(.*)Votre mobilité \\?", Pattern.DOTALL);
        regexMatcher = regex21.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex22 = Pattern.compile("Votre mobilité \\?(.*)Quelle est votre remuneration aujourd'hui\\? ou dernier poste\\?", Pattern.DOTALL);
        regexMatcher = regex22.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex23 = Pattern.compile("Quelle est votre remuneration aujourd'hui\\? ou dernier poste\\?(.*)Vos prétentions salariales \\?", Pattern.DOTALL);
        regexMatcher = regex23.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex24 = Pattern.compile("Vos prétentions salariales \\?(.*)Quelle est votre disponibilité \\? Etes-vous en processus de recrutement dans un autre cabinet \\?", Pattern.DOTALL);
        regexMatcher = regex24.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex25 = Pattern.compile("Quelle est votre disponibilité \\? Etes-vous en processus de recrutement dans un autre cabinet \\?(.*)\n" +
                "Personnes à contacter pour une prise de référence\\?", Pattern.DOTALL);
        regexMatcher = regex25.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex26 = Pattern.compile("Personnes à contacter pour une prise de référence\\?(.*)Avez-vous des questions \\? Voulez-vous revenir sur un point que nous n'aurions pas abordé \\?", Pattern.DOTALL);
        regexMatcher = regex26.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex27 = Pattern.compile("Avez-vous des questions \\? Voulez-vous revenir sur un point que nous n'aurions pas abordé \\?(.*)--", Pattern.DOTALL);
        regexMatcher = regex27.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);
    }

    @Test
    public void testRegex() {
        // your code goes here
        String search = "code:xy??";

        Matcher regexMatcher;
        String ResultString = null;
        String newSearch = search.replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\");
        System.out.println(newSearch);

        String temp = newSearch ;
        newSearch = newSearch +"(.*)";

        String model  = "code\\:xy\\?\\?"+"(.*)" ;
        Pattern regex1 = Pattern.compile(model, Pattern.DOTALL);
        regexMatcher = regex1.matcher(search+"autre camel");
        if (regexMatcher.find()) {
            ResultString = regexMatcher.group(1);
        }
        System.out.println(newSearch);
        System.out.println(ResultString);
    }


    @Test
    public void escapeSpecials () {
        String testStr = "< > \" &";

        System.out.println("Original : " + testStr);

        System.out.println("Escaped : " + StringEscapeUtils.escapeHtml(testStr));
    }
}
