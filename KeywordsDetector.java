public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    } 

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        int length1 = sentences.length;
        int length2 = keywords.length;
        String[] sentences2 = new String[length1];
        String[] keywords2 = new String[length2];
        for (int i = 0; i < length1; i++) {
            sentences2[i] = sentences[i].toLowerCase();
        }
        for (int i = 0; i < length2; i++) {
            keywords2[i] = keywords[i].toLowerCase();
        }
        for (int i = 0; i < length1; i++) {
            for ( int j = 0; j < length2; j++) {
                if (MyString.contains(sentences2[i],keywords2[j])) {
                    System.out.println(sentences[i]);
                    break; // break out of inner loop if a keyword is found in a sentence
                }
            }
         }
    }
}
