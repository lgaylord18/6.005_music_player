grammar Body;
import Configuration;

body : body_line+ EOF;
body_line : (voice | element+ | comment | NEWLINE) NEWLINE?;
comment : '%' string?;
voice : 'V:' string;
element : note_element | rest | tuplet | barline | repeat | WHITESPACE;

note_element: note | chord;
note : ACCIDENTAL? NOTE_LETTERS OCTAVE? (time | NUMBER)?;
rest : REST_LETTERS (time | NUMBER)?;
chord : '[' note+ ']';
tuplet : TUPLET_START note_element+;
barline : '|' | '||' | '[|' | '|]' | ':|' | '|:';
repeat : '[1' | '[2';
string : (NOTE_LETTERS | OTHER_LETTERS | REST_LETTERS | NUMBER | WHITESPACE | '.' | OCTAVE)+; //do we need commas and apostrophes

ACCIDENTAL : '_' | '__' | '^' | '^^' | '=';		// "^" is sharp, "_" is flat, and "=" is neutral
NOTE_LETTERS: [A-Ga-g];
OCTAVE : (',' | '\'')+;
time : NUMBER? '/' NUMBER?;
TUPLET_START: '(2' | '(3' | '(4';

OTHER_LETTERS : [H-Yh-y]+;
REST_LETTERS : 'Z' | 'z';
NUMBER : [0-9]+;
WHITESPACE : [ ]+;
END_BAR: '[|' | '||' | '|]';
NEWLINE : [\r?\n];


/* Tell Antlr to ignore spaces around tokens. */
SPACES : [ ]+ -> skip;
