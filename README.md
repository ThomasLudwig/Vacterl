# Vacterl

## Input Files

### Common Columns

1. SmapEntryID
2. QryContigID  
3. RefcontigID1  
4. RefcontigID2  
5. QryStartPos  
6. QryEndPos  
7. RefStartPos  
8. RefEndPos  
9. Confidence  
10. Type  
11. XmapID1  
12. XmapID2  
13. LinkID  
14. QryStartIdx  
15. QryEndIdx  
16. RefStartIdx  
17. RefEndIdx  
18. Zygosity  
19. Genotype  
20. GenotypeGroup  
21. RawConfidence  
22. RawConfidenceLeft  
23. RawConfidenceRight  
24. RawConfidenceCenter  
25. SVsize  
26. SVfreq  
27. Orientation  
28. VAF  
29. Sample  
30. Algorithm  
31. Size  
32. Present_in_%_of_BNG_control_samples  
33. Present_in_%_of_BNG_control_samples_with_the_same_enzyme  
34. %_of_BNG_control_sample_with_homozygous_SV  
35. %_of_BNG_control_sample_with_heterozygous_SV  
36. %_of_AFR_BNG_control_sample_with_SV  
37. %_of_AMR_BNG_control_sample_with_SV  
38. %_of_EUR_BNG_control_sample_with_SV  
39. %_of_EAS_BNG_control_sample_with_SV  
40. %_of_SAS_BNG_control_sample_with_SV  
41. %_of_unknown_BNG_control_sample_with_SV  
42. Fail_assembly_chimeric_score  
43. num_overlap_DGV_calls  
44. OverlapGenes  
45. NearestNonOverlapGene  
46. NearestNonOverlapGeneDistance  
47. PutativeGeneFusion  

### Mono samples

48. Found_in_self_molecules  
49. Self_molecule_count  
50. UCSC_web_link1  
51. UCSC_web_link2  
52. ISCN

### Trio samples

48. Found_in_parents_assemblies  
49. Found_in_parents_molecules  
50. Found_in_self_molecules  
51. Mother_molecule_count  
52. Father_molecule_count  
53. Self_molecule_count  
54. UCSC_web_link1  
55. UCSC_web_link2  
56. ISCN

### Control samples

48. Found_in_parents_assemblies  
49. Found_in_parents_molecules  
50. Found_in_self_molecules  
51. Control_molecule_count  
52. Self_molecule_count  
53. UCSC_web_link1  
54. UCSC_web_link2  
55. ISCN

## Parameters

- percentBNG : max value for `Present_in_%_of_BNG_control_samples` (Line is dropped otherwise)
- percentBNGEnzyme : max value for `Present_in_%_of_BNG_control_samples_with_the_same_enzyme` (Line is dropped otherwise)
- input_file_directory : directory containing the input `.smap` files

## Output Files

| Group | NbSamples | SOURCE | RefcontigID1 | RefcontigID2 | RefStartPos | RefEndPos | Type | Zygosity | Present_in_percent_of_BNG_control_samples | Present_in_percent_of_BNG_control_samples_with_the_same_enzyme | OverlapGenes | NearestNonOverlapGene |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---- | --- | --- |
| G0 | 2 | EXT230046 | 1 | 1 | 3.0002013E7 | 3.0022777E7 | deletion | heterozygous | 0.0 | 0.0 | LINC01648 | LINC01756 |
| G0 | 2 | EXT230046 | 1 | 1 | 3.0002013E7 | 3.0022777E7 | deletion | heterozygous | 0.0 | 0.0 | LINC01648 | LINC01756 |
| G1 | 5 | CGH230970 | 1 | 15 | 4.597235E7 | 8.9308338E7 | translocation_interchr | heterozygous | 0.0 | 0.0 | "MAST2;FANCI" | POLG |
| G1 | 5 | EXT240016 | 1 | 1 | 5.4652778E7 | 5.4668176E7 | insertion | heterozygous | 0.0 | 0.0 | MROH7-TTC4;MROH7 | ACOT11 |
| G1 | 5 | EXT230033 | 1 | 1 | 6.6814755E7 | 6.6824793E7 | insertion | heterozygous | 0.0 | 0.0 | DNAI4 | INSL5 |
| G1 | 5 | CGH221041 | 1 | 1 | 6.7476006E7 | 6.7499629E7 | insertion | heterozygous | 0.0 | 0.0 | - | SERBP1 |
| G1 | 5 | EXT230024 | 1 | 1 | 7.0637709E7 | 7.0660938E7 | insertion | heterozygous | 0.0 | 0.0 | - | LINC01788 |
| G2 | 4 | EXT230046 | 1 | 1 | 1.25078433E8 | 1.25095187E8 | insertion | heterozygous | 0.0 | 0.0 | - | EMBP1 |
| G2 | 4 | EXT230046 | 1 | 1 | 1.25078433E8 | 1.25095187E8 | insertion | heterozygous | 0.0 | 0.0 | - | EMBP1 |
| G2 | 4 | EXT240023 | 1 | 1 | 1.25078433E8 | 1.25095187E8 | insertion | heterozygous | 0.0 | 0.0 | - | EMBP1 |
| G2 | 4 | EXT230023 | 1 | 1 | 1.25078433E8 | 1.25095187E8 | insertion | heterozygous | 0.0 | 0.0 | - | EMBP1 |

## Algorithm

- Sort all regions
- Groups overlapping regions
- Count samples in each group
