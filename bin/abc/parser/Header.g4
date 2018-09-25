grammar Header;
import Configuration;

header : index_field comment* title_field optional_fields* key_field;
index_field : 'X:' WHITESPACE? NUMBER end_line;
title_field : 'T:' WHITESPACE? string? end_line;
comment : '%' WHITESPACE? string NEWLINE;
optional_fields : composer_field | length_field | meter_field | tempo_field | voice_field | comment;
composer_field : 'C:' WHITESPACE? string end_line;
length_field : 'L:' WHITESPACE? length end_line;
meter_field : 'M:' WHITESPACE? meter end_line;
tempo_field : 'Q:' WHITESPACE? tempo end_line;
voice_field : 'V:' WHITESPACE? string end_line;
key_field : 'K:' WHITESPACE? key EOF;

end_line : NEWLINE | comment;
key : (KEY_SIG_LETTER | C) ('#' | '_')? M?;
string : (KEY_SIG_LETTER | C | NUMBER | M | OTHER_LETTER | WHITESPACE | '.' | ',' | '\'' | '/' | '_' | '-' | ':' )+;
length : NUMBER* '/' NUMBER*;
meter : (NUMBER '/' NUMBER) | C | C'|';
tempo : (meter '=')? NUMBER;

KEY_SIG_LETTER : [ABD-G];
C : 'C';
M : 'm';
OTHER_LETTER : [H-Za-ln-z];
NUMBER : [0-9]+;
NEWLINE : [\r?\n];
WHITESPACE : [ ]+;