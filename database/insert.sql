INSERT INTO question(questionid, question, difficulty)
values (1, 'Wie viele Plastikteile schwimmern in den Meeren', 7),
       (2, 'Wie viele Tonnen Plastik wurden im Jahr 2015 produziert?', 7),
       (3, 'Was ist die kürzeste Lebenszeit von Plastik?', 4),
       (4, 'Was ist die längste Lebenszeit von Plastik?', 5),
       (5, 'Was produziert am meisten Plastikmüll?', 3),
       (6, 'Wie veil prozent des Plastiks wird nur einmal verwendet, und dann weggeworfen?', 7),
       (7, 'Wie viele Plastikteile landen täglich in unseren Ozeanen?', 8),
       (8, 'Wie viel Plastikmüll produzieren wir jährlich?', 7),
       (9, 'Gibt es in den Ozeanen mehr Plastikteile als Sterne in der Milchstraße', 6),
       (10, 'Wie viel des auf dem Wasser schwimmenden Eises is in den letzen 30 Jahren geschmolzen?', 3),
       (11, 'Was ist das größte Problem mit Meeresfischen?', 2),
       (12, 'Wie viel unseres Meereslebens wurde noch nicht erforscht?', 6),
       (13, 'Wie viel Lebensmittel werfen wir jedes Jahr durchschnittlich weg?', 4),
       (14, 'Was war das wärmste Jahre seit Beobachtungsbeginn (Stand 2019)', 2),
       (15, 'Wie viel Prozent haben Bienen seit den 80er Jahren abgenommen?', 9),
       (16, 'Wie viel Klopapier verbrauchen wir durchschnittlich jedes Jahr?', 3),
       (17, 'Was sind die größten Verursacher von mikroplastik?', 9),
       (18, 'Wie viel Plastik essen wir ca. jeder Woche?', 4),
       (19, 'Was ist die am meist ausgelöste Krankheit durch Mikroplastik?', 8),
       (20, 'Um wie viel Grad Celsius war die Erde vor 4,5 Millionen Jahren kühler?', 6);
       (21, 'Um wie viel Prozent ist die CO2-Konzentration durch menschliches Handeln seit dem Jahr 1850 bis 2020 gestiegen?', 8);
       (22, 'Wie viel Hektar Wald müssten angelegt werden um im Jahr 2050 die Klimaneutralität zu erreichen?', 7);
       (23, 'Um wie viel steigt der Meeresspiegel pro Jahr?', 6);
       (24, 'Um wie viel Hektar vergrößert sich die Wüste im Jahr?', 6);

INSERT INTO answer (answerid, answer, iscorrect, worth, questionid)
values (1, '1 million', false, 0, 1),
       (2, '1 billion', false, 0, 1),
       (3, '5 billion', true, 1, 1),
       (4, '10 billion', false, 0, 1),

       (5, '~100 million', false, 0, 2),
       (6, '~368 million', false, 0, 2),
       (7, '~400 million', true, 1, 2),
       (8, '~1 billion', false, 0, 2),

       (9, '100 Jahre', false, 0, 3),
       (10, '300 Jahre', false, 0, 3),
       (11, '400 Jahre', true, 1, 3),
       (12, '1000 Jahre', false, 0, 3),

       (13, '100 Jahre', false, 0, 4),
       (14, '500 Jahre', false, 0, 4),
       (15, '1000 Jahre', false, 0, 4),
       (16, 'fast für immer', true, 0, 4),

       (17, 'Verpackungen', true, 1, 5),
       (18, 'Plastikflaschen', false, 0, 5),
       (19, 'Spielzeug', false, 0, 5),
       (20, 'Essen', false, 0, 5),

       (21, '20%', false, 0, 6),
       (22, '60%', false, 0, 6),
       (23, '40%', true, 1, 6),
       (24, '80%', false, 0, 6),

       (25, '100.000', false, 0, 7),
       (26, '4 million', false, 0, 7),
       (27, '8 million', true, 1, 7),
       (28, 'über 10 millionen', false, 0, 7),

       (29, '~100 millionen', false, 0, 8),
       (30, '~400 millionen', true, 1, 8),
       (31, 'über 800 millionen', false, 0, 8),
       (32, 'nichts', false, 0, 8),

       (33, 'ja', true, 1, 9),
       (34, 'nein', false, 0, 9),

       (35, '10%', false, 0, 10),
       (36, '30%', false, 0, 10),
       (37, '50%', false, 0, 10),
       (38, '75%', true, 1, 10),

       (39, 'Sie sind zu salzig, da diese aus dem Salzwasser kommen', false, 0, 11),
       (40, 'es wurde immer wieder Plastik in den Mägen gefunden', true, 1, 11),
       (41, 'es wurde immer wieder Plastik im Mund gefunden', false, 0, 11),
       (42, 'es wurden immer wieder schwere Giftstoffe wie Öl oder Nervengift in ihnen Gefunden', false, 0, 11),

       (44, '50%', false, 0, 12),
       (45, '33%', true, 1, 12),
       (46, '60%', false, 0, 12),
       (47, '10%', false, 0, 12),

       (48, '80kg', true, 1, 13),
       (49, '100kg', false, 0, 13),
       (50, '1 tonne', false, 0, 13),
       (51, '10 kg', false, 0, 13),

       (52, '2002', false, 0, 14),
       (53, '2019', true, 1, 14),
       (54, '2010', false, 0, 14),
       (55, '2017', false, 0, 14),

       (56, '20%', false, 0, 15),
       (57, '50%', false, 0, 15),
       (58, '80%', true, 1, 15),
       (59, '60%', false, 0, 15),

       (60, '105 Rollen', false, 0, 16),
       (61, '200 kg', false, 0, 16),
       (62, '46 Rollen', true, 1, 16),
       (63, '500 kg', false, 0, 16),

       (64, 'Verpackungen', false, 0, 17),
       (65, 'Autos', true, 1, 17),
       (66, 'Plastikflaschen', false, 0, 17),

       (67, '1 kg', false, 0, 18),
       (68, 'eine Kreditkarte', true, 1, 18),
       (69, 'ein Plastiksackerl', false, 0, 18),
       (70, '300 g', false, 0, 18),

       (71, 'Covid 19', false, 0, 19),
       (72, 'Alzheimer', false, 0, 19),
       (73, 'Krebs', true, 1, 19),
       (74, 'Herzprobleme', false, 0, 19);

        (75, '12 Grad', false, 0, 20),
        (76, '8 Grad', false, 0, 20),
        (77, '4 Grad', true , 1, 20),
        (78, '0 Grad', false, 0, 20);

        (79, '64%', false, 0, 21),
        (80, '48%', true, 1, 21),
        (81, '32%', false, 0, 21),
        (82, '11%', false, 0, 21);

        (83, '1,6 Billionen Hektar', false, 0, 22),
        (84, '1,6 Milliarden Hektar', true, 1, 22),
        (85, '1,6 Millionen Hektar', false, 0, 22),
        (86, '160 000 Hektar', false, 0, 22);

        (87, '1,78 Meter', false, 0, 23),
        (88, '1,78 Dezimeter', false, 0, 23),
        (89, '1,78 Zentimeter', true, 1, 23),
        (90, '1,78 Millimeter', false, 0, 23);

        (91, '12 Billionen Hektar', false, 0, 24),
        (92, '12 Milliarden Hektar', false, 0, 24),
        (93, '12 Millionen Hektar', true, 1, 24),
        (94, '120 000 Hektar', false, 0, 24);





