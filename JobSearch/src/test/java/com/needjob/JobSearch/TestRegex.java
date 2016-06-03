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
        String data = "Pourquoi vous quittez votre soci�t� actuelle ? Que cherchez-vous ? \n" +
                " Dernier entretien annuel d�cevant = pas d'augmentation \n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Quelle exp�rience est la plus/moins enrichissante ? \n" +
                " LE BON COIN \n" +
                "Conception de cubes\n" +
                "Probl�matique de volum�trie\n" +
                "\n" +
                "  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez-vous m'expliquez l'organisation des projets dans l'exp�rience la plus significative, du recueil du besoin jusqu'� la livraison en production ?\" \n" +
                "le candidat doit pr�senter les diff�rentes phases et activit�s sp�cifiques � l'entreprise dans laquelle il est intervenu travail sur plusieurs projet en meme tps\n" +
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
                "Ma�trisez-vous un outil d�cisionnel? Le(s)quel(s) ? \n" +
                "Et combien d'ann�es au cumul? Pentaho 3 ans\n" +
                "Talend 1 an\n" +
                "SQL 3ans  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me donner une definition d�indicateur de pilotage? \n" +
                "\"c'est une information, dont la consultation am�ne � un savoir important sur la direction prise par une entreprise\". La consultation d'un indicateur de pilotage doit permettre de prendre des d�cisions : augmenter/diminuer les investissements, am�liorer la qualit�... En anglais, on parle de KPI : Key Performance Indicator indicateur qui fourni des infos d�taill� de l�activit� et qui permet au d�cideur de prendre des d�cisions  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous d�j� particip� � la conception d�un entrep�t de donn�es ou datawarehouse ? Cbien de temps ? \n" +
                "cf. sch�ma de la cha�ne d�cisionnelle. L'entrep�t de donn�es est une base de donn�es o� l'on r�cup�re, th�oriquement, toutes les donn�es de l'entreprise pour des besoins en reporting. En anglais : Datawarehouse (DWH). Il existe �galement le terme Datamart (magasin de donn�es, DMT). C'est une base de donn�es d�cisionnelle cibl�e sur une partie pr�cise du m�tier de l'entreprise (ex : indicateurs RH). En clair, un DWH ou un DMT contient des indicateurs. Ces indicateurs sont organis�es d'une mani�re particuli�re, cf VIP Day du 18/4/2014. oui 3 ans \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous d�j� particip� � la conception d�un Univers (comme on l'appelle dans Business Objects) ? Cbien de temps? \n" +
                "L'univers se place au-dessus du DWH, il permet de lister et d'acc�der aux indicateurs depuis une solution de reporting. Ex : si dans ton DWH tu as l'indicateur dont le nom technique est IND-CA-41, dans ton univers, tu pourras faire correspondre ce nom technique avec le nom d'indicateur, plus facilement compr�hensible par l'utilisateur, suivant : \"Chiffre d'affaire par activit�s de conseil\". L'utilisateur, au moment de cr�er son rapport, a ainsi toutes les infos sur les indicateurs disponibles. On dit que dans un univers, on cr�e des informations qui ont du sens pour l'analyse de l'utilisateur (couche s�mantique). On parle aussi de Metadata  business table : langage Pentaho\n" +
                "cr�ation de domaine couche... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous d�j� particip� � la conception d�un cube ? Cbien de temps ? \n" +
                "Un cube de donn�es (multidimensionnel) est une autre forme de repr�sentation et stockage des donn�es. Ce n'est pas comme une base de donn�es, mais �a peut s'appuyer sur une base de donn�es sous-jacente. Il y a des avantages � stocker les donn�es dans un cube : rapidit� d'acc�s, possibilit� de modification des indicateurs... Le choix d'un cube ou une base d�pend du contexte et du besoin des utilisateurs. oui 2 ans \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Cr�ation de rapports d'analyse ? Cbien de temps ? \n" +
                "Les rapports sont cr��s � partir d'univers/metadata et sont ensuite analys�s par les utilisateurs. G�n�ralement, les utilisateurs ont acc�s au syst�me qui permet de cr�er ses propres rapports d'analyse (ex : Business Objects Web Intelligence). Pour les rapports complexes, ce sont les informaticiens (MOE ou MOA) qui s'en occupent. oui \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me donner une definition de Recette ?  \n" +
                "(importance, strat�gie) v�rifier si le fonctionnement pr�vu par le cahier charge est fonctionnel \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous r�alis� une Formation Utilisateur ? \n" +
                " oui \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Comment voyez-vous votre �volution dans les 5 prochaines ann�es ? \n" +
                " chef de projet \n" +
                "Pourquoi pas de la big data... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Qu�attendez-vous de votre soci�t� de conseil ? \n" +
                "(animation, management) missions int�ressantes\n" +
                "\n" +
                "mission longue duree \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Vos principales qualit�s ? Defauts ? \n" +
                "Dans quelles circonstances avez-vous fait preuve des qualit�s que vous dites poss�der ? honn�tet� parfois manque de filtre \n" +
                "\n" +
                "j'aime le travail bien fait \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Etes vous capable de vous adapter rapidement? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction ? Oui bcp de mission courtes contexte diff�rents... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Comment vous comportez-vous face au stress/aux �checs? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction ? Les �checs me font avancer... \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Dit-on de vous que vous etes organis� ? \n" +
                "Quelles difficult�s importantes avez-vous rencontr�es dans votre dernier poste ? Comment les avez-vous surmont�s ?  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Donnez une note sur 20 � votre motivation ?  \n" +
                "Expliquez l�ecart avec 20? 20/20 \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "De quoi �tes-vous le plus fier dans votre carri�re ? \n" +
                "Formation, projet expertise outils open source \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Pouvez vous me preciser ce que vous avez compris de notre soci�t� ? \n" +
                " bi\n" +
                "package \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Votre mobilit� ?  \n" +
                "(Banlieue, Province, R�gion, Pays, Internationale)   \n" +
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
                "Vos pr�tentions salariales ?  \n" +
                "  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Quelle est votre disponibilit� ? Etes-vous en processus de recrutement dans un autre cabinet ? \n" +
                " 3 mois negociable \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Personnes � contacter pour une prise de r�f�rence?  *\n" +
                " Ne souhaite pas communiquer de contact \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Avez-vous des questions ? Voulez-vous revenir sur un point que nous n'aurions pas abord� ? \n" +
                " PROCESS \n" +
                "--";

//        data = data
//                .replaceAll("[(]"," ")
//                .replaceAll("[)]" ," ")
//                .replaceAll("[/]", " ")
//                .replaceAll("[?]", " ") ;

//       data =  data.replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\");
       // System.out.println(data);
        
        String data1 = "Pourquoi vous quittez votre soci�t� actuelle ? Que cherchez-vous ?" ; 
        data1 = data1.replaceAll("[?]", "\\\\\\?") ; 
        System.out.println(data1);

        Matcher regexMatcher;
        String ResultString = "no  match";
        Pattern regex1 = Pattern.compile("Que cherchez-vous(.*)Quelle exp�rience est la plus moins enrichissante   ", Pattern.DOTALL);
        regexMatcher = regex1.matcher(data);
        if (regexMatcher.find()) {
            ResultString = regexMatcher.group(1);
        }

        System.out.println(ResultString);

        Pattern regex2 = Pattern.compile("Quelle exp�rience est la plus\\/moins enrichissante \\?(.*)Pouvez-vous m'expliquez l'organisation des projets dans l'exp�rience la plus significative, du recueil du besoin jusqu'� la livraison en production \\?", Pattern.DOTALL);
        regexMatcher = regex2.matcher(data);
        if (regexMatcher.find()) {
            ResultString = regexMatcher.group(1);
        }
        System.out.println(ResultString);
        String res = null;
        Pattern regex3 = Pattern.compile("Pouvez-vous m'expliquez l'organisation des projets dans l'exp�rience la plus significative, du recueil du besoin jusqu'� la livraison en production \\?\" \n" +
                "le candidat doit pr�senter les diff�rentes phases et activit�s sp�cifiques � l'entreprise dans laquelle il est intervenu travail sur plusieurs projet en meme tps(.*)Ma�trisez-vous un outil d�cisionnel\\? Le\\(s\\)quel\\(s\\) \\?", Pattern.DOTALL);
        regexMatcher = regex3.matcher(data);
        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }
        System.out.println(res);

        res = "no match !!";
        Pattern regex4 = Pattern.compile("Ma�trisez-vous un outil d�cisionnel\\? Le\\(s\\)quel\\(s\\) \\? \n" +
                "Et combien d'ann�es au cumul\\? (.*)Pouvez vous me donner une definition d�indicateur de pilotage?", Pattern.DOTALL);
        regexMatcher = regex4.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex5 = Pattern.compile("Pouvez vous me donner une definition d�indicateur de pilotage\\?(.*)\n" +
                "Avez-vous d�j� particip� � la conception d�un entrep�t de donn�es ou datawarehouse \\? Cbien de temps \\? ", Pattern.DOTALL);
        regexMatcher = regex5.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }
        System.out.println(res);
        res = "no match !!";
        Pattern regex6 = Pattern.compile("Avez-vous d�j� particip� � la conception d�un entrep�t de donn�es ou datawarehouse \\? Cbien de temps \\?(.*)Avez-vous d�j� particip� � la conception d�un Univers \\(comme on l'appelle dans Business Objects\\) \\? Cbien de temps\\? ", Pattern.DOTALL);
        regexMatcher = regex6.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex7 = Pattern.compile("Avez-vous d�j� particip� � la conception d�un Univers \\(comme on l'appelle dans Business Objects\\) \\? Cbien de temps\\? (.*)Avez-vous d�j� particip� � la conception d�un cube \\? Cbien de temps \\?", Pattern.DOTALL);
        regexMatcher = regex7.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex8 = Pattern.compile("Avez-vous d�j� particip� � la conception d�un cube \\? Cbien de temps \\?(.*)Cr�ation de rapports d'analyse \\? Cbien de temps \\?", Pattern.DOTALL);
        regexMatcher = regex8.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex9 = Pattern.compile("Cr�ation de rapports d'analyse \\? Cbien de temps \\?(.*)Pouvez vous me donner une definition de Recette \\?", Pattern.DOTALL);
        regexMatcher = regex9.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex10 = Pattern.compile("Pouvez vous me donner une definition de Recette \\?(.*)Avez-vous r�alis� une Formation Utilisateur \\?", Pattern.DOTALL);
        regexMatcher = regex10.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex11 = Pattern.compile("Avez-vous r�alis� une Formation Utilisateur \\?(.*)Comment voyez-vous votre �volution dans les 5 prochaines ann�es \\?", Pattern.DOTALL);
        regexMatcher = regex11.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex12 = Pattern.compile("Comment voyez-vous votre �volution dans les 5 prochaines ann�es \\?(.*)Qu�attendez-vous de votre soci�t� de conseil \\?", Pattern.DOTALL);
        regexMatcher = regex12.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex13 = Pattern.compile("Qu�attendez-vous de votre soci�t� de conseil \\?(.*)Vos principales qualit�s \\? Defauts \\?", Pattern.DOTALL);
        regexMatcher = regex13.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);
        res = "no match !!";
        Pattern regex14 = Pattern.compile("Vos principales qualit�s \\? Defauts \\?(.*)Etes vous capable de vous adapter rapidement\\?", Pattern.DOTALL);
        regexMatcher = regex14.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex15 = Pattern.compile("Vos principales qualit�s \\? Defauts \\? \n" +
                "Dans quelles circonstances avez-vous fait preuve des qualit�s que vous dites poss�der \\? honn�tet� parfois manque de filtre(.*)\n" +
                "Etes vous capable de vous adapter rapidement\\? ", Pattern.DOTALL);
        regexMatcher = regex15.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex16 = Pattern.compile("Etes vous capable de vous adapter rapidement\\? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction \\?(.*)Comment vous comportez-vous face au stress\\/aux �checs\\?", Pattern.DOTALL);
        regexMatcher = regex16.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);
        res = "no match !!";
        Pattern regex17 = Pattern.compile("Comment vous comportez-vous face au stress\\/aux �checs\\? \n" +
                "Comment occuperiez-vous les 30 premiers jours de votre prise de fonction \\?(.*)Dit-on de vous que vous etes organis� \\?", Pattern.DOTALL);
        regexMatcher = regex17.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex18 = Pattern.compile("Dit-on de vous que vous etes organis� \\?(.*)Donnez une note sur 20 � votre motivation \\?", Pattern.DOTALL);
        regexMatcher = regex18.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex19 = Pattern.compile("Donnez une note sur 20 � votre motivation \\?  \n" +
                "Expliquez l�ecart avec 20\\?(.*)De quoi �tes-vous le plus fier dans votre carri�re \\?", Pattern.DOTALL);
        regexMatcher = regex19.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex20 = Pattern.compile("De quoi �tes-vous le plus fier dans votre carri�re \\?(.*)Pouvez vous me preciser ce que vous avez compris de notre soci�t� \\?", Pattern.DOTALL);
        regexMatcher = regex20.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex21 = Pattern.compile("Pouvez vous me preciser ce que vous avez compris de notre soci�t� \\?(.*)Votre mobilit� \\?", Pattern.DOTALL);
        regexMatcher = regex21.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex22 = Pattern.compile("Votre mobilit� \\?(.*)Quelle est votre remuneration aujourd'hui\\? ou dernier poste\\?", Pattern.DOTALL);
        regexMatcher = regex22.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex23 = Pattern.compile("Quelle est votre remuneration aujourd'hui\\? ou dernier poste\\?(.*)Vos pr�tentions salariales \\?", Pattern.DOTALL);
        regexMatcher = regex23.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex24 = Pattern.compile("Vos pr�tentions salariales \\?(.*)Quelle est votre disponibilit� \\? Etes-vous en processus de recrutement dans un autre cabinet \\?", Pattern.DOTALL);
        regexMatcher = regex24.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex25 = Pattern.compile("Quelle est votre disponibilit� \\? Etes-vous en processus de recrutement dans un autre cabinet \\?(.*)\n" +
                "Personnes � contacter pour une prise de r�f�rence\\?", Pattern.DOTALL);
        regexMatcher = regex25.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex26 = Pattern.compile("Personnes � contacter pour une prise de r�f�rence\\?(.*)Avez-vous des questions \\? Voulez-vous revenir sur un point que nous n'aurions pas abord� \\?", Pattern.DOTALL);
        regexMatcher = regex26.matcher(data);

        if (regexMatcher.find()) {
            res = regexMatcher.group(1);
        }

        System.out.println(res);

        res = "no match !!";
        Pattern regex27 = Pattern.compile("Avez-vous des questions \\? Voulez-vous revenir sur un point que nous n'aurions pas abord� \\?(.*)--", Pattern.DOTALL);
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
