// Generated from /home/luis/Documents/Teoria de la Computacion/Parser/TeoriaGrammarP2.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TeoriaGrammarP2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WHITESPACE=2, ID=3, ADD_OP=4, MULT_OP=5, LOG_OP=6, REL_OP=7, 
		ASIG=8, PERIOD=9, DDPERIOD=10, INCR=11, FALSE_LITERAL=12, TRUE_LITERAL=13, 
		INT_LITERAL=14, REAL_LITERAL=15, STRING_LITERAL=16, DATE_LITERAL=17, WHILE=18, 
		IF=19, ELSE=20, RETURN=21, INICIO=22, IF_THEN=23, DO=24, END=25, SEMICOLON=26, 
		PAR_OP=27, PAR_CL=28, BRACK_OP=29, BRACK_CL=30, COMA=31, EPSILON=32, STATIC_TKN=33, 
		INT_TYPE=34, ANYTYPE_TYPE=35, BOOLEAN_TYPE=36, VOID_TYPE=37, REAL_TYPE=38, 
		STRING_TYPE=39, DATE_TYPE=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "WHITESPACE", "ID", "ADD_OP", "MULT_OP", "LOG_OP", "REL_OP", 
		"ASIG", "PERIOD", "DDPERIOD", "INCR", "FALSE_LITERAL", "TRUE_LITERAL", 
		"INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "DATE_LITERAL", "WHILE", 
		"IF", "ELSE", "RETURN", "INICIO", "IF_THEN", "DO", "END", "SEMICOLON", 
		"PAR_OP", "PAR_CL", "BRACK_OP", "BRACK_CL", "COMA", "EPSILON", "STATIC_TKN", 
		"INT_TYPE", "ANYTYPE_TYPE", "BOOLEAN_TYPE", "VOID_TYPE", "REAL_TYPE", 
		"STRING_TYPE", "DATE_TYPE", "DIGIT", "LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "':='", "'.'", "'::'", 
		"'++'", "'false'", "'true'", null, null, null, null, "'while'", "'if'", 
		"'else'", "'EXIT'", "'BEGIN'", "'THEN'", "'DO'", "'END'", "';'", "'('", 
		"')'", "'{'", "'}'", "','", "'E'", "'static'", "'int'", "'anytype'", "'boolean'", 
		"'void'", "'real'", "'String'", "'date'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "WHITESPACE", "ID", "ADD_OP", "MULT_OP", "LOG_OP", "REL_OP", 
		"ASIG", "PERIOD", "DDPERIOD", "INCR", "FALSE_LITERAL", "TRUE_LITERAL", 
		"INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "DATE_LITERAL", "WHILE", 
		"IF", "ELSE", "RETURN", "INICIO", "IF_THEN", "DO", "END", "SEMICOLON", 
		"PAR_OP", "PAR_CL", "BRACK_OP", "BRACK_CL", "COMA", "EPSILON", "STATIC_TKN", 
		"INT_TYPE", "ANYTYPE_TYPE", "BOOLEAN_TYPE", "VOID_TYPE", "REAL_TYPE", 
		"STRING_TYPE", "DATE_TYPE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TeoriaGrammarP2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TeoriaGrammarP2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0130\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\7\2\\\n\2\f\2\16\2_\13\2\3\2\5\2b\n\2\3\2\3\2\3\2\3\2\3"+
		"\3\6\3i\n\3\r\3\16\3j\3\3\3\3\3\4\3\4\5\4q\n\4\3\4\3\4\7\4u\n\4\f\4\16"+
		"\4x\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0082\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u008b\n\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\6\17\u00a4"+
		"\n\17\r\17\16\17\u00a5\3\20\6\20\u00a9\n\20\r\20\16\20\u00aa\3\20\3\20"+
		"\6\20\u00af\n\20\r\20\16\20\u00b0\3\21\3\21\3\21\3\21\7\21\u00b7\n\21"+
		"\f\21\16\21\u00ba\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)"+
		"\3)\3)\3*\3*\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S\2U\2\3\2\n\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\4\2--//\4\2,,\61\61\4\2>>@@\t\2\"\"\'\'*+./??B"+
		"Baa\3\2\62;\4\2C\\c|\2\u013d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\3W\3\2\2\2\5h\3\2\2\2\7p\3\2\2\2\ty\3\2\2\2\13{\3\2\2"+
		"\2\r\u0081\3\2\2\2\17\u008a\3\2\2\2\21\u008c\3\2\2\2\23\u008f\3\2\2\2"+
		"\25\u0091\3\2\2\2\27\u0094\3\2\2\2\31\u0097\3\2\2\2\33\u009d\3\2\2\2\35"+
		"\u00a3\3\2\2\2\37\u00a8\3\2\2\2!\u00b2\3\2\2\2#\u00bd\3\2\2\2%\u00c8\3"+
		"\2\2\2\'\u00ce\3\2\2\2)\u00d1\3\2\2\2+\u00d6\3\2\2\2-\u00db\3\2\2\2/\u00e1"+
		"\3\2\2\2\61\u00e6\3\2\2\2\63\u00e9\3\2\2\2\65\u00ed\3\2\2\2\67\u00ef\3"+
		"\2\2\29\u00f1\3\2\2\2;\u00f3\3\2\2\2=\u00f5\3\2\2\2?\u00f7\3\2\2\2A\u00f9"+
		"\3\2\2\2C\u00fb\3\2\2\2E\u0102\3\2\2\2G\u0106\3\2\2\2I\u010e\3\2\2\2K"+
		"\u0116\3\2\2\2M\u011b\3\2\2\2O\u0120\3\2\2\2Q\u0127\3\2\2\2S\u012c\3\2"+
		"\2\2U\u012e\3\2\2\2WX\7\61\2\2XY\7\61\2\2Y]\3\2\2\2Z\\\n\2\2\2[Z\3\2\2"+
		"\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2\2_]\3\2\2\2`b\7\17\2\2a`\3\2"+
		"\2\2ab\3\2\2\2bc\3\2\2\2cd\7\f\2\2de\3\2\2\2ef\b\2\2\2f\4\3\2\2\2gi\t"+
		"\3\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\b\3\2\2m\6"+
		"\3\2\2\2nq\5U+\2oq\7a\2\2pn\3\2\2\2po\3\2\2\2qv\3\2\2\2ru\5U+\2su\5S*"+
		"\2tr\3\2\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\b\3\2\2\2xv\3\2"+
		"\2\2yz\t\4\2\2z\n\3\2\2\2{|\t\5\2\2|\f\3\2\2\2}~\7~\2\2~\u0082\7~\2\2"+
		"\177\u0080\7(\2\2\u0080\u0082\7(\2\2\u0081}\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0082\16\3\2\2\2\u0083\u008b\t\6\2\2\u0084\u0085\7?\2\2\u0085\u008b\7"+
		"?\2\2\u0086\u0087\7>\2\2\u0087\u008b\7?\2\2\u0088\u0089\7@\2\2\u0089\u008b"+
		"\7?\2\2\u008a\u0083\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0086\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\20\3\2\2\2\u008c\u008d\7<\2\2\u008d\u008e\7?\2\2"+
		"\u008e\22\3\2\2\2\u008f\u0090\7\60\2\2\u0090\24\3\2\2\2\u0091\u0092\7"+
		"<\2\2\u0092\u0093\7<\2\2\u0093\26\3\2\2\2\u0094\u0095\7-\2\2\u0095\u0096"+
		"\7-\2\2\u0096\30\3\2\2\2\u0097\u0098\7h\2\2\u0098\u0099\7c\2\2\u0099\u009a"+
		"\7n\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\32\3\2\2\2\u009d\u009e"+
		"\7v\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"\34\3\2\2\2\u00a2\u00a4\5S*\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2"+
		"\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\36\3\2\2\2\u00a7\u00a9"+
		"\5S*\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\7\60\2\2\u00ad\u00af\5"+
		"S*\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1 \3\2\2\2\u00b2\u00b8\7$\2\2\u00b3\u00b7\5U+\2\u00b4"+
		"\u00b7\5S*\2\u00b5\u00b7\t\7\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2"+
		"\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7$\2\2\u00bc"+
		"\"\3\2\2\2\u00bd\u00be\5S*\2\u00be\u00bf\5S*\2\u00bf\u00c0\7\61\2\2\u00c0"+
		"\u00c1\5S*\2\u00c1\u00c2\5S*\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4\5S*\2"+
		"\u00c4\u00c5\5S*\2\u00c5\u00c6\5S*\2\u00c6\u00c7\5S*\2\u00c7$\3\2\2\2"+
		"\u00c8\u00c9\7y\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc"+
		"\7n\2\2\u00cc\u00cd\7g\2\2\u00cd&\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0"+
		"\7h\2\2\u00d0(\3\2\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4"+
		"\7u\2\2\u00d4\u00d5\7g\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7G\2\2\u00d7\u00d8"+
		"\7Z\2\2\u00d8\u00d9\7K\2\2\u00d9\u00da\7V\2\2\u00da,\3\2\2\2\u00db\u00dc"+
		"\7D\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7I\2\2\u00de\u00df\7K\2\2\u00df"+
		"\u00e0\7P\2\2\u00e0.\3\2\2\2\u00e1\u00e2\7V\2\2\u00e2\u00e3\7J\2\2\u00e3"+
		"\u00e4\7G\2\2\u00e4\u00e5\7P\2\2\u00e5\60\3\2\2\2\u00e6\u00e7\7F\2\2\u00e7"+
		"\u00e8\7Q\2\2\u00e8\62\3\2\2\2\u00e9\u00ea\7G\2\2\u00ea\u00eb\7P\2\2\u00eb"+
		"\u00ec\7F\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7=\2\2\u00ee\66\3\2\2\2\u00ef"+
		"\u00f0\7*\2\2\u00f08\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2:\3\2\2\2\u00f3\u00f4"+
		"\7}\2\2\u00f4<\3\2\2\2\u00f5\u00f6\7\177\2\2\u00f6>\3\2\2\2\u00f7\u00f8"+
		"\7.\2\2\u00f8@\3\2\2\2\u00f9\u00fa\7G\2\2\u00faB\3\2\2\2\u00fb\u00fc\7"+
		"u\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100"+
		"\7k\2\2\u0100\u0101\7e\2\2\u0101D\3\2\2\2\u0102\u0103\7k\2\2\u0103\u0104"+
		"\7p\2\2\u0104\u0105\7v\2\2\u0105F\3\2\2\2\u0106\u0107\7c\2\2\u0107\u0108"+
		"\7p\2\2\u0108\u0109\7{\2\2\u0109\u010a\7v\2\2\u010a\u010b\7{\2\2\u010b"+
		"\u010c\7r\2\2\u010c\u010d\7g\2\2\u010dH\3\2\2\2\u010e\u010f\7d\2\2\u010f"+
		"\u0110\7q\2\2\u0110\u0111\7q\2\2\u0111\u0112\7n\2\2\u0112\u0113\7g\2\2"+
		"\u0113\u0114\7c\2\2\u0114\u0115\7p\2\2\u0115J\3\2\2\2\u0116\u0117\7x\2"+
		"\2\u0117\u0118\7q\2\2\u0118\u0119\7k\2\2\u0119\u011a\7f\2\2\u011aL\3\2"+
		"\2\2\u011b\u011c\7t\2\2\u011c\u011d\7g\2\2\u011d\u011e\7c\2\2\u011e\u011f"+
		"\7n\2\2\u011fN\3\2\2\2\u0120\u0121\7U\2\2\u0121\u0122\7v\2\2\u0122\u0123"+
		"\7t\2\2\u0123\u0124\7k\2\2\u0124\u0125\7p\2\2\u0125\u0126\7i\2\2\u0126"+
		"P\3\2\2\2\u0127\u0128\7f\2\2\u0128\u0129\7c\2\2\u0129\u012a\7v\2\2\u012a"+
		"\u012b\7g\2\2\u012bR\3\2\2\2\u012c\u012d\t\b\2\2\u012dT\3\2\2\2\u012e"+
		"\u012f\t\t\2\2\u012fV\3\2\2\2\20\2]ajptv\u0081\u008a\u00a5\u00aa\u00b0"+
		"\u00b6\u00b8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}