package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 2020/3/13.
 * Licensed under WTFPL©2020.
 */
public class DrunkStringsTest {
    private DrunkStrings drunkStrings = new DrunkStrings();

    @Test
    public void testGcdOfStrings_Case1() {
        assertEquals(drunkStrings.gcdOfStrings("ABABAB", "ABAB"), "AB");
    }

    @Test
    public void testGcdOfStrings_Case2() {
        assertEquals(drunkStrings.gcdOfStrings("ABCABC", "ABC"), "ABC");
    }

    @Test
    public void testGcdOfStrings_Case3() {
        assertEquals(drunkStrings.gcdOfStrings("LEET", "CODE"), "");
    }

    @Test
    public void testCountCharacters_1() {
        String[] dict = {"cat", "bt", "hat", "tree"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "atach"), 6);
    }

    @Test
    public void testCountCharacters_2() {
        String[] dict = {"hello", "world", "leetcode"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "welldonehoneyr"), 10);
    }

    @Test
    public void testCountCharacters_Fail1() {
        String[] dict = {
                "pxlqovnbsgvqjzpfeidchzrodnbqfrccfydzjptukscjuatlsrcurepllxzyghhdepitqptlmfkhzxjgswaulxkfydhkilg",
                "uqklvqnlhdkwryjawkqfajfpbcnhglxlwxlaskxlytr", "jvgkxcdkxrvfahjkvhmfuyjzxtyxrsogbtsjybeaxugqymcr",
                "rgxditmosplnqvodtis", "jm",
                "ruqjwejuanjtiizcmbieobesnjnadzqvqumggblzmkxilgfarnxwpcawtkzxlvugibpidvwtikloeziuxqoi",
                "wxeyzrnbhlhwxecrgejsrawyulynvgtszwqqlihkcvckgcgtgpyqtkuwvjywmhpskaiwmpyarftqhnogxpith",
                "vdpbykqlihtpvfnqbrcjpggojqbalerohyitktuikbffvfatcnneuvbanjihiaorrjcdthntnrxebfhvshmpodmzhtwnasbm",
                "wgjstkoaojcesfdrllugmojwdmgeejyiqvshlowtktddattunarnohgvqsoskfmbrami",
                "ecwqxbawirvnxvsjybbebclaturorlcbpf",
                "gtjbaigvufrotlwfoqqolnjabnvtbcygtfcytinzpcjbvprdkdjawrcbthmxjrabimhhs",
                "cvzlbrvppkyxtjxzeglzwoagmpjnfxddbwolxmwdohgtfktgftzzkwpianslkpldyfzubtjczse", "neaw",
                "mxhmvkajofnmdiiduactlemcvpztscmsnrdhuhquxnnzywsrzxyplgbppiypxwcfbsnyzblaeifo",
                "krekecabfpufucjhqphjnibaeqdvdpmrfougdwugvoioqangdnxromwlxnfeydaneyazzclscqgdxlhhgnoqmslfflzqv",
                "klutvchxsceihfmzitgqakytesfjykribjhjzdruuoycjkwaghmmqkfrhkrtawudtjyjwqbyspamlegqjlwlj",
                "raykfkflqdzrpthdejetwolgciygwaktulkxemkdbbllkjxhnnafsms", "os",
                "xhchkcetmlprcdmrnalvkvgabxxnomphqpqhnddqhecogspbdebeoshvjgzvmqu",
                "jqtdysnpskktynxwmsfaabglagnqcllptvuyyqjwrmqaftenusmsahhhqubkwxltpr",
                "sulmwluiwvlroldpiyecaicwrawzwflokefqkdwmxejaovvpbflfdtviinbvvtlhhhefmgfsqs", "sxyhcckvyl",
                "vsaacsybcddxvuzkddjmuivsvtjyanpbydmkcwnkmxvsiantgkvkmqjysclsvd", "sxcghypulvmfqfunxj",
                "pozekufhlooosxpcggbi", "xzaoxzllcixfqbupqozmzrnugj", "j", "tgslwp",
                "ntrdkixexajlpjgmcbrqimwtqnzfrqjszeiuvrgzclerzmsnagzaxbredvlrmipzflrzusclckmxphc",
                "ifdflsywdfizpodsehrrifsvejcxarrxmxyjgbbvqyqvywncphzfmnxhybxpdcozfnzablfx",
                "uluhplzrsaehaqxfnbcmixueedevhirbwqdyztwaxnkogcauymxgcpabxekib",
                "agtfkinbdccoemxetbryzpluzlpyzicnfopphrxriqm",
                "pdympxpwvxwcqaxrvbvyqkrresrjgzgxuyfxtkgldtathokdbyfsqfmitmiyagtqgijaiazvsumeyutbbwxqdshquzrehn",
                "rqe", "sljsvenhhstnnngzqyo", "dezrzpgldeimxfoqajuhjctgvalwkhkjemjaxumxqmifglbizusuqlttxirpbqbuvauwy",
                "dkwpyezbmkcskoxxcgrxcewknqgdckjxfyzcmzqcbyeucxbqybxoldogtkmdknsrruvnlfqnpfx",
                "sjeftmjkuperfynbreycwhuoyqybticswblbrrpugzhlrmiedjqufnehevzqwtaebwvdswsz",
                "lolnfyliloqmhjmhhohdtgfajjfdjqpubslbsrwitbjmrcegdrdjzvonxaefdvdfcbqmaaks",
                "qhcoaiocjhuzywkirlblajgeapzajqsoa",
                "sxrmoqxqbtakuqwmrrkljmegbwbeqbywmlyuprwyhljzejbybxoumidpxdrohwdjoqycpxcmivaulnqzneydwqfsvcxgyyseuk",
                "yrowy", "dohrzkrzdjehpctnjrvhzojullsiucrhphshwxwicyzkvzbqrztic",
                "rmshnxtbhsdgkiijrmwulocdzjzpgfyimkjdthuzkhoqgkeawgwincubrloknocxwzgqqcxafksxgzh",
                "aymovnuhptozhkiyowbeguzlkmrwjnujgjbdne", "abc", "vxoigovwmqizmkwbkktqk",
                "uokwktdempzloaglvvkqstztmwzcmhgxtoua", "bzwjxqueazlzfojrkbqmhtwrvuwsnfcnylurnddpektekca",
                "qgndjgvzcyajhgmrrnhdywwdbmkhtthwcfiueuxfldanyrmccwcy"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "figspbov"), 2);
    }
}
